package com.tli.amin.enums;

/**
 * Created by KrishnaPrasad on 16/07/2017.
 */
public enum IdentificationType {
    PASSPORT("PP","Passport"),
    AADHAR_CARD("AC","Aadhar Card"),
    DRIVING_LICENCE("DL","Driving Licence");

    private final String type;
    private final  String description;

    IdentificationType(String type,String description){
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
