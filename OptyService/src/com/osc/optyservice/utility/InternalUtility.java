package com.osc.optyservice.utility;

import com.osc.optyservice.dto.OSCIntegrationRequest;
import com.osc.optyservice.valueobject.InternalOSCOptyValueObject;

public class InternalUtility {


    public static InternalOSCOptyValueObject validateRequest(OSCIntegrationRequest oscIntReq) {
        
        InternalOSCOptyValueObject internalVO = new InternalOSCOptyValueObject();
        
        if(oscIntReq.getUsername() == null || oscIntReq.getPassword() == null || oscIntReq.getTransactionType() != null) {
            
            internalVO.setError(true);
            
        } else {
            
            // how much more checking is needed on requests?
            // need to null check - the needed info will depend on the transaction type (i.e. FIND won't have a OptyID)
            
            internalVO.setTransactionType(oscIntReq.getTransactionType());
            internalVO.setOptyId(oscIntReq.getOptyId());
            internalVO.setOptyName(oscIntReq.getOptyName());
            internalVO.setUsername(oscIntReq.getUsername());
            internalVO.setPassword(oscIntReq.getPassword());
        }
        return internalVO;
    }
}
