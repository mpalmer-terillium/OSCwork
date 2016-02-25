package com.osc.optyservice.utility;

import com.osc.optyservice.dto.OSCIntegrationRequest;
import com.osc.optyservice.valueobject.InternalOSCOptyValueObject;

import com.osc.optyservice.valueobject.SoftCodingCredentials;

import java.io.InputStream;

import java.net.HttpURLConnection;
import java.net.URL;

import javax.xml.bind.JAXBContext;

import static com.osc.optyservice.constants.OptyServiceConstants.*;

import java.util.logging.Logger;

public class InternalUtility {
    
    private static Logger logger = Logger.getLogger("Util");


    public static InternalOSCOptyValueObject validateRequest(OSCIntegrationRequest oscIntReq) {
        
        InternalOSCOptyValueObject internalVO = new InternalOSCOptyValueObject();
        SoftCodingCredentials cred = securitySetup();
        
        if(!cred.hasCredentials() || oscIntReq.getTransactionType() == null) {
            
            internalVO.setError(true);
            
        } else {
            internalVO.setUsername(cred.getUsername());
            internalVO.setPassword(cred.getPassword());
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
    
    /**
     * public method to call the REST mock softcoding service.
     * @return
     */
    public static SoftCodingCredentials securitySetup() {
        return setUsernamePassword(new SoftCodingCredentials());
    }
    
    /**
     * this is a mock softcoding call - it will be used in JDE to get user information, currently running locally
     * as another (here REST) service.
     * 
     * @param scr 
     * @return SoftCodingCredentials
     */
    private static SoftCodingCredentials setUsernamePassword(SoftCodingCredentials scr) {
        try {
            URL url = new URL(SOFTCODING_URI);
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("GET");
            connection.setRequestProperty("Accept", "application/xml");
            
            JAXBContext jaxbContext = JAXBContext.newInstance(SoftCodingCredentials.class);
            InputStream xml = connection.getInputStream();
            
            scr = (SoftCodingCredentials) jaxbContext.createUnmarshaller().unmarshal(xml);
            
            connection.disconnect();
        } catch (Exception e) {
            logger.severe(e.toString());
        }
        return scr;
    }
}
