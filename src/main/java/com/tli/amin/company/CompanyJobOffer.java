package com.tli.amin.company;

import com.tli.amin.model.BaseEntity;

import javax.persistence.*;
import java.util.*;

/**
 * Created by KrishnaPrasad on 17/07/2017.
 */
@Entity
public class CompanyJobOffer extends BaseEntity {

    @ManyToOne
    @JoinColumn(name = "company_id")
    private Company company;
    private Long jobRefNumber;
    private String jobTitle;
    private Date closingDate;

    public Company getCompany() {
        return company;
    }

    public void setCompany(Company company) {
        this.company = company;
    }

    public Long getJobRefNumber() {
        return jobRefNumber;
    }

    public void setJobRefNumber(Long jobRefNumber) {
        this.jobRefNumber = jobRefNumber;
    }

    public String getJobTitle() {
        return jobTitle;
    }

    public void setJobTitle(String jobTitle) {
        this.jobTitle = jobTitle;
    }

    public Date getClosingDate() {
        return closingDate;
    }

    public void setClosingDate(Date closingDate) {
        this.closingDate = closingDate;
    }
}
