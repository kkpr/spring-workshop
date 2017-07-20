package com.tli.amin.enums;

public enum DocumentType {
    COMPANY_REGISTRATION("CR","Company Registration"),
    AUTHORIZATION_LETTER("AL","Authorization Letter") ;

    private final String type;
    private final  String description;

    DocumentType(String type,String description){
        this.type = type;
        this.description = description;
    }

    public String getType() {
        return type;
    }

    public String getDescription() {
        return description;
    }
}
