package com.tli.amin.candidate;

import com.tli.amin.enums.IdentificationType;
import com.tli.amin.model.BaseEntity;

import javax.persistence.*;

/**
 * Created by KrishnaPrasad on 16/07/2017.
 */
@Entity
public class CandidateIdentification extends BaseEntity{

    @ManyToOne
    @JoinColumn(name = "candidate_id")
    private Candidate candidate;

    @Enumerated(EnumType.STRING)
    @Column(name = "id_type")
    private IdentificationType identificationType;

    private String identificationNumber;

    private String identificationFilepath;

    public Candidate getCandidate() {
        return candidate;
    }

    public void setCandidate(Candidate candidate) {
        this.candidate = candidate;
    }

    public IdentificationType getIdentificationType() {
        return identificationType;
    }

    public void setIdentificationType(IdentificationType identificationType) {
        this.identificationType = identificationType;
    }

    public String getIdentificationNumber() {
        return identificationNumber;
    }

    public void setIdentificationNumber(String identificationNumber) {
        this.identificationNumber = identificationNumber;
    }

    public String getIdentificationFilepath() {
        return identificationFilepath;
    }

    public void setIdentificationFilepath(String identificationFilepath) {
        this.identificationFilepath = identificationFilepath;
    }
}
