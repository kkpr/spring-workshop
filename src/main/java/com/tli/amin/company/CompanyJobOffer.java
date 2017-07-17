package com.tli.amin.company;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.tli.amin.candidate.Candidate;
import com.tli.amin.candidate.CandidateJobOffer;
import com.tli.amin.model.BaseEntity;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;
import java.util.Set;

/**
 * Created by KrishnaPrasad on 17/07/2017.
 */
@Entity
public class CompanyJobOffer extends BaseEntity {
    private Company company;
    private Long jobRefNumber;
    private String jobTitle;

    @OneToMany(cascade = CascadeType.ALL,fetch = FetchType.LAZY,mappedBy = "companyJobOffer")
    @JsonManagedReference
    private Set<CandidateJobOffer> candidateJobOffers;

    public Company getCompany() {
        return company;
    }

    public void setCompany(Company company) {
        this.company = company;
    }

    public Set<CandidateJobOffer> getCandidateJobOffers() {
        return candidateJobOffers;
    }

    public void setCandidateJobOffers(Set<CandidateJobOffer> candidateJobOffers) {
        this.candidateJobOffers = candidateJobOffers;
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
}
