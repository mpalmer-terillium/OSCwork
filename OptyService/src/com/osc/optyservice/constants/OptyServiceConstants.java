package com.osc.optyservice.constants;

public final class OptyServiceConstants {
    
    public static final String TRANS_TYPE_CREATE         = "CREATE";
    public static final String TRANS_TYPE_READ           = "READ";
    public static final String TRANS_TYPE_UPDATE         = "UPDATE";
    public static final String TRANS_TYPE_DELETE         = "DELETE";
    
    public static final String ERROR_INVALID_TRANS_TYPE  = "ERROR: Invalid Transaction Type";
    
    public static final String ERROR_UNKNOWN             = "ERROR: Unknown";
    
    public static final String TRANSFORMER_PROPERTY      = "javax.xml.transform.TransformerFactory";
    public static final String TRANSFORMER_IMPL_PROPERTY = "com.sun.org.apache.xalan.internal.xsltc.trax.TransformerFactoryImpl";
    public static final String SECURITY_POLICIES_FEATURE = "oracle/wss_username_token_over_ssl_client_policy";
}
