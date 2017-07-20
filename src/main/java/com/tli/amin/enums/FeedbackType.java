package com.tli.amin.enums;

/**
 * Created by KrishnaPrasad on 17/07/2017.
 */
public enum FeedbackType {
    ACCEPTED("A","Accepted"),
    REJECTED("R","Rejected"),
    WITHDRAWN("W","Withdrawn");

    private final String type;
    private final  String description;

    FeedbackType(String type,String description){
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
