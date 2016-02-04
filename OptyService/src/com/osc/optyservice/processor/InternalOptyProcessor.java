package com.osc.optyservice.processor;

import com.oracle.xmlns.adf.svc.types.Conjunction;
import com.oracle.xmlns.adf.svc.types.FindControl;
import com.oracle.xmlns.adf.svc.types.FindCriteria;
import com.oracle.xmlns.adf.svc.types.ViewCriteria;
import com.oracle.xmlns.adf.svc.types.ViewCriteriaItem;
import com.oracle.xmlns.adf.svc.types.ViewCriteriaRow;
import com.oracle.xmlns.apps.sales.opptymgmt.opportunities.opportunityservice.Opportunity;
import com.oracle.xmlns.apps.sales.opptymgmt.opportunities.opportunityservice.OpportunityService;
import com.oracle.xmlns.apps.sales.opptymgmt.opportunities.opportunityservice.OpportunityService_Service;

import com.osc.optyservice.dto.OSCIntegrationResponse;
import static com.osc.optyservice.constants.OptyServiceConstants.*;
import com.osc.optyservice.valueobject.InternalOSCOptyValueObject;

import java.util.List;
import java.util.Map;
import java.util.logging.Logger;

import javax.xml.ws.BindingProvider;

import weblogic.wsee.jws.jaxws.owsm.SecurityPoliciesFeature;

public class InternalOptyProcessor {
    
    protected static OpportunityService_Service opportunityService_Service;
    protected OpportunityService opportunityService;
    private Logger logger = Logger.getLogger("CRM");
    
    public InternalOptyProcessor(InternalOSCOptyValueObject internalVO) {
        super();
        init(internalVO.getUsername(), internalVO.getPassword());
    }
    
    protected void init(String username, String password) {
        System.setProperty(TRANSFORMER_PROPERTY, TRANSFORMER_IMPL_PROPERTY);
        
        opportunityService_Service = new OpportunityService_Service();
        
        //Configure security feature
        SecurityPoliciesFeature securityFeatures = 
            new SecurityPoliciesFeature(new String[] { SECURITY_POLICIES_FEATURE });
        
        opportunityService = opportunityService_Service.getOpportunityServiceSoapHttpPort(securityFeatures);
        
        Map<String,Object> reqContext = ((BindingProvider)opportunityService).getRequestContext();
        
        reqContext.put(BindingProvider.USERNAME_PROPERTY, username);
        reqContext.put(BindingProvider.PASSWORD_PROPERTY, password);
    }
    
    
    
    public OSCIntegrationResponse internalProcessCreateTransaction(InternalOSCOptyValueObject internalVO) {
        return null;
    }

    public OSCIntegrationResponse internalProcessReadTransaction(InternalOSCOptyValueObject internalVO) {
        
        OSCIntegrationResponse response = new OSCIntegrationResponse();
        
        FindCriteria fc = new FindCriteria();
        fc.setFetchStart(0);
        fc.setFetchSize(-1);
        
        ViewCriteria vc = new ViewCriteria();
        vc.setConjunction(Conjunction.fromValue("And"));
        
        ViewCriteriaRow vcr = new ViewCriteriaRow();
        vcr.setConjunction(Conjunction.fromValue("And"));
        vcr.setUpperCaseCompare(false);
        
        ViewCriteriaItem vci = new ViewCriteriaItem();
        vci.setConjunction(Conjunction.fromValue("And"));
        vci.setUpperCaseCompare(true);
        vci.setAttribute("Name");
        vci.setOperator("=");
        vci.getValue().add(internalVO.getOptyName());
        
        vcr.getItem().add(vci);
        vc.getGroup().add(vcr);
        fc.setFilter(vc);
        
        try {
            FindControl findControl = new FindControl();
            findControl.setRetrieveAllTranslations(false);
            
            List<Opportunity> results = opportunityService.findOpportunity(fc, findControl);
            
            if(results.size() > 0) {
                internalVO.setOptyId(results.get(0).getOptyId().toString());
            }
        } catch (Exception e) {
            logger.severe("Exception in FIND: " + e.toString());
        }
        
        response.setResponse("RETURNED OPPORTUTNITY ID: " + internalVO.getOptyId());
        
        return response;
    }

    public OSCIntegrationResponse internalProcessUpdateTransaction(InternalOSCOptyValueObject internalVO) {
        return null;
    }

    public OSCIntegrationResponse internalProcessDeleteTransaction(InternalOSCOptyValueObject internalVO) {
        return null;
    }
}
