package com.osc.optyservice.valueobject;

import javax.xml.datatype.XMLGregorianCalendar;

public class InternalOSCOptyValueObject {
    
    private boolean error;
    private String username;
    private String password;
    private String optyId;
    private String optyName;
    private String transactionType;
    private String description;
    private XMLGregorianCalendar lastUpdateTimestamp;
    
    public InternalOSCOptyValueObject() {
        this.error = false;
    }

    public void setError(boolean error) {
        this.error = error;
    }

    public boolean hasError() {
        return error;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getUsername() {
        return username;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPassword() {
        return password;
    }

    public void setOptyId(String optyId) {
        this.optyId = optyId;
    }

    public String getOptyId() {
        return optyId;
    }

    public void setOptyName(String optyName) {
        this.optyName = optyName;
    }

    public String getOptyName() {
        return optyName;
    }

    public void setTransactionType(String transactionType) {
        this.transactionType = transactionType;
    }

    public String getTransactionType() {
        return transactionType;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }

    public void setLastUpdateTimestamp(XMLGregorianCalendar lastUpdateTimestamp) {
        this.lastUpdateTimestamp = lastUpdateTimestamp;
    }

    public XMLGregorianCalendar getLastUpdateTimestamp() {
        return lastUpdateTimestamp;
    }
}
