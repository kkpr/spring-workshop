package com.tli.amin.candidate;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.tli.amin.model.BaseEntity;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;
import java.util.Set;

/**
 * Created by KrishnaPrasad on 16/07/2017.
 */
@Entity
public class Candidate extends BaseEntity {

    private String firstname;
    private String middlename;
    private String lastname;
    private String fathername;
    private String contactNumber;
    private String alternateContactNumber;
    private String emailId;

    @OneToMany(cascade = CascadeType.ALL,fetch = FetchType.LAZY,mappedBy = "candidate")
    @JsonManagedReference
    private Set<CandidateIdentification> candidateIdentifications;

    public Candidate() {
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getMiddlename() {
        return middlename;
    }

    public void setMiddlename(String middlename) {
        this.middlename = middlename;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getFathername() {
        return fathername;
    }

    public void setFathername(String fathername) {
        this.fathername = fathername;
    }

    public String getContactNumber() {
        return contactNumber;
    }

    public void setContactNumber(String contactNumber) {
        this.contactNumber = contactNumber;
    }

    public String getAlternateContactNumber() {
        return alternateContactNumber;
    }

    public void setAlternateContactNumber(String alternateContactNumber) {
        this.alternateContactNumber = alternateContactNumber;
    }

    public String getEmailId() {
        return emailId;
    }

    public void setEmailId(String emailId) {
        this.emailId = emailId;
    }

    public Set<CandidateIdentification> getCandidateIdentifications() {
        return candidateIdentifications;
    }

    public void setCandidateIdentifications(Set<CandidateIdentification> candidateIdentifications) {
        this.candidateIdentifications = candidateIdentifications;
    }


}
