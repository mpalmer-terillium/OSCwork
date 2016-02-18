package com.osc.optyservice.service;

import com.osc.optyservice.dto.OSCIntegrationRequest;
import com.osc.optyservice.dto.OSCIntegrationResponse;

import javax.jws.WebMethod;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;
import javax.jws.soap.SOAPBinding.Style;


public interface OptyService {
    
    
    OSCIntegrationResponse processOSCIntegrationRequest(OSCIntegrationRequest oscIntReq);
}
