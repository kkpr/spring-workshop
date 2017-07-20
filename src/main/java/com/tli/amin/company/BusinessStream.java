package com.tli.amin.company;

import com.tli.amin.model.BaseEntity;

import javax.persistence.Entity;

/**
 * Created by KrishnaPrasad on 17/07/2017.
 */
@Entity
public class BusinessStream extends BaseEntity{

    private String businessStreamName;

    public String getBusinessStreamName() {
        return businessStreamName;
    }

    public void setBusinessStreamName(String businessStreamName) {
        this.businessStreamName = businessStreamName;
    }
}
