package com.osc.optyservice.constants;

public final class OptyServiceConstants {
    
    public static final String TRANS_TYPE_CREATE         = "CREATE";
    public static final String TRANS_TYPE_READ           = "READ";
    public static final String TRANS_TYPE_UPDATE         = "UPDATE";
    public static final String TRANS_TYPE_DELETE         = "DELETE";
    
    public static final String NAME_ATTRIBUTE            = "Name";
    public static final String EQUALS_OPERATOR           = "=";
    
    public static final String ERROR_INVALID_TRANS_TYPE  = "ERROR: Invalid Transaction Type";
    
    public static final String EXCEPTION_CREATE          = "Exception in CREATE: ";
    public static final String CREATED_OPTY_MSG          = "CREATED OPPORTUNITY ID: ";
    
    public static final String EXCEPTION_FIND            = "Exception in FIND: ";
    public static final String FIND_OPTY_MSG             = "RETURNED OPPORTUTNITY ID: ";
    
    public static final String EXCEPTION_UPDATE          = "Exception in UPDATE: ";
    public static final String UPDATE_OPTY_MSG           = "UPDATE TIMESTAMP: ";
    
    public static final String EXCEPTION_DELETE          = "Exception in DELETE: ";
    public static final String DELETE_OPTY_MSG           = "DELETED OPPORTUNITY ID: ";
    
    public static final String ERROR_UNKNOWN             = "ERROR: Unknown";
    
    public static final String TRANSFORMER_PROPERTY      = "javax.xml.transform.TransformerFactory";
    public static final String TRANSFORMER_IMPL_PROPERTY = "com.sun.org.apache.xalan.internal.xsltc.trax.TransformerFactoryImpl";
    public static final String SECURITY_POLICIES_FEATURE = "oracle/wss_username_token_over_ssl_client_policy";
    
    public static final String QNAME_UPDATE              = "updateOpportunity";
    public static final String LOGGER_NAME               = "CRM";
    
    public static final String OPTY_ID_INIT              = "ID NOT FOUND";
}
