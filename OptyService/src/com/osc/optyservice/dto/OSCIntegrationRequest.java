package com.osc.optyservice.dto;

public class OSCIntegrationRequest {
    
    private String username;
    private String password;
    private String optyId;
    private String optyName;
    private String transactionType;


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
}
