package com.osc.optyservice.service;

import static com.osc.optyservice.constants.OptyServiceConstants.ERROR_INVALID_TRANS_TYPE;
import static com.osc.optyservice.constants.OptyServiceConstants.ERROR_UNKNOWN;
import static com.osc.optyservice.constants.OptyServiceConstants.TRANS_TYPE_CREATE;
import static com.osc.optyservice.constants.OptyServiceConstants.TRANS_TYPE_DELETE;
import static com.osc.optyservice.constants.OptyServiceConstants.TRANS_TYPE_READ;
import static com.osc.optyservice.constants.OptyServiceConstants.TRANS_TYPE_UPDATE;
import com.osc.optyservice.dto.OSCIntegrationRequest;
import com.osc.optyservice.dto.OSCIntegrationResponse;
import com.osc.optyservice.processor.InternalOptyProcessor;
import com.osc.optyservice.utility.InternalUtility;
import com.osc.optyservice.valueobject.InternalOSCOptyValueObject;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;


@WebService
@SOAPBinding(style = SOAPBinding.Style.RPC)
public class OptyServiceImpl implements OptyService {
    
    @Override
    @WebMethod
    public OSCIntegrationResponse processOSCIntegrationRequest(@WebParam(name = "request")
                                                               OSCIntegrationRequest oscIntReq) {
        
        OSCIntegrationResponse oscResp = new OSCIntegrationResponse();
        
        InternalOSCOptyValueObject internalVO = InternalUtility.validateRequest(oscIntReq);
        
        if(!internalVO.hasError()) {
            
            InternalOptyProcessor optyProcessor = new InternalOptyProcessor(internalVO);
            
            switch (internalVO.getTransactionType()) {
            
                case TRANS_TYPE_CREATE:
                    oscResp = optyProcessor.internalProcessCreateTransaction(internalVO);
                    break;
                case TRANS_TYPE_READ:
                    oscResp = optyProcessor.internalProcessReadTransaction(internalVO);
                    break;
                case TRANS_TYPE_UPDATE:
                    oscResp = optyProcessor.internalProcessUpdateTransaction(internalVO);
                    break;
                case TRANS_TYPE_DELETE:
                    oscResp = optyProcessor.internalProcessDeleteTransaction(internalVO);
                    break;
                default:
                    setError(oscResp, -1);
                    break;
            }
        } else {
            setError(oscResp, -2);
        }
        return oscResp;
    }
    
    private void setError(OSCIntegrationResponse oscResp, int errno) {
        
        if(errno == -1) {
            oscResp.setResponse(ERROR_INVALID_TRANS_TYPE);
        } else {
            oscResp.setResponse(ERROR_UNKNOWN);
        }
    }
}
