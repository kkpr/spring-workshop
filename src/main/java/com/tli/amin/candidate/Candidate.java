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

    private String firstName;
    private String lastName;
    private String middleName;
    private String fatherName;
    private String contactNumber;
    private String alternateContactNumber;
    private String emailId;

    @OneToMany(cascade = CascadeType.ALL,fetch = FetchType.LAZY,mappedBy = "candidate")
    @JsonManagedReference
    private Set<CandidateIdentification> candidateIdentifications;

    @OneToMany(cascade = CascadeType.ALL,fetch = FetchType.LAZY,mappedBy = "candidate")
    @JsonManagedReference
    private Set<CandidateJobOffer> candidateJobOffers;

    public Candidate() {
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getMiddleName() {
        return middleName;
    }

    public void setMiddleName(String middleName) {
        this.middleName = middleName;
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

    public String getFatherName() {
        return fatherName;
    }

    public void setFatherName(String fatherName) {
        this.fatherName = fatherName;
    }

    public Set<CandidateIdentification> getCandidateIdentifications() {
        return candidateIdentifications;
    }

    public void setCandidateIdentifications(Set<CandidateIdentification> candidateIdentifications) {
        this.candidateIdentifications = candidateIdentifications;
    }


}
