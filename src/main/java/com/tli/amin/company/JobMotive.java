package com.tli.amin.company;

import com.tli.amin.model.BaseEntity;

import javax.persistence.Entity;

/**
 * Created by KrishnaPrasad on 17/07/2017.
 */
@Entity
public class JobMotive extends BaseEntity{
    private String question;

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }
}
