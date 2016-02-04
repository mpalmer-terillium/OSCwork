package com.osc.optyservice;

import com.osc.optyservice.service.OptyServiceImpl;

import javax.xml.ws.Endpoint;

public class OSCOpportunityService {
    
    /**
     * Main method imitating a deployed BSSV. SOAP requests would be made from outside in the same way.
     * @param args
     */
    public static void main(String[] args) {
        Endpoint.publish("http://localhost:8080/optyservice", new OptyServiceImpl());
    }
}
