package com.osc.optyservice.processor;

import com.osc.optyservice.dto.OSCIntegrationResponse;
import com.osc.optyservice.valueobject.InternalOSCOptyValueObject;

public class InternalOptyProcessor {
    
    
    public OSCIntegrationResponse internalProcessCreateTransaction(InternalOSCOptyValueObject internalVO) {
        return null;
    }

    public OSCIntegrationResponse internalProcessReadTransaction(InternalOSCOptyValueObject internalVO) {
        
        OSCIntegrationResponse response = new OSCIntegrationResponse();
        
        return response;
    }

    public OSCIntegrationResponse internalProcessUpdateTransaction(InternalOSCOptyValueObject internalVO) {
        return null;
    }

    public OSCIntegrationResponse internalProcessDeleteTransaction(InternalOSCOptyValueObject internalVO) {
        return null;
    }
}
