package com.osc.optyservice.utility;

import com.osc.optyservice.dto.OSCIntegrationRequest;
import com.osc.optyservice.valueobject.InternalOSCOptyValueObject;

public class InternalUtility {


    public static InternalOSCOptyValueObject validateRequest(OSCIntegrationRequest oscIntReq) {
        
        InternalOSCOptyValueObject internalVO = new InternalOSCOptyValueObject();
        
        if(oscIntReq.getUsername() == null || oscIntReq.getPassword() == null || oscIntReq.getTransactionType() == null) {
            
            internalVO.setError(true);
            
        } else {
            internalVO.setUsername(oscIntReq.getUsername());
            internalVO.setPassword(oscIntReq.getPassword());
            internalVO.setTransactionType(oscIntReq.getTransactionType());
            
            if(oscIntReq.getOptyId() != null) {
                internalVO.setOptyId(oscIntReq.getOptyId()); 
            }
            if(oscIntReq.getOptyName() != null) {
                internalVO.setOptyName(oscIntReq.getOptyName());
            }
            if(oscIntReq.getDescription() != null) {
                internalVO.setDescription(oscIntReq.getDescription());
            }
        }
        return internalVO;
    }
}
