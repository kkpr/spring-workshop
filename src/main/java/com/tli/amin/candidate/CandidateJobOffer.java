package com.tli.amin.candidate;

import com.tli.amin.company.CompanyJobOffer;
import com.tli.amin.model.BaseEntity;

import javax.persistence.*;
import java.util.Date;

/**
 * Created by KrishnaPrasad on 17/07/2017.
 */
@Entity
public class CandidateJobOffer extends BaseEntity {

    @ManyToOne
    @JoinColumn(name = "candidate_id")
    private Candidate candidate;
    @ManyToOne
    @JoinColumn(name = "company_job_offer_id")
    private CompanyJobOffer companyJobOffer;

    private Date offerDate;

    public CandidateJobOffer() {
    }

    public Candidate getCandidate() {
        return candidate;
    }

    public void setCandidate(Candidate candidate) {
        this.candidate = candidate;
    }

    public CompanyJobOffer getCompanyJobOffer() {
        return companyJobOffer;
    }

    public void setCompanyJobOffer(CompanyJobOffer companyJobOffer) {
        this.companyJobOffer = companyJobOffer;
    }

    public Date getOfferDate() {
        return offerDate;
    }

    public void setOfferDate(Date offerDate) {
        this.offerDate = offerDate;
    }

}
