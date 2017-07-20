package com.tli.amin.candidate;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.tli.amin.enums.FeedbackType;
import com.tli.amin.model.BaseEntity;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.util.Date;
import java.util.Set;

/**
 * Created by KrishnaPrasad on 17/07/2017.
 */
@Entity
public class CandidateOfferFeedback extends BaseEntity{

    @ManyToOne
    @JoinColumn(name = "candidate_offer_id")
    private CandidateOffer candidateOffer;

    @Enumerated(EnumType.STRING)
    @Column(name = "feedback_type")
    private FeedbackType feedbackType;

    @Temporal(TemporalType.TIMESTAMP)
    @DateTimeFormat(pattern = "yyyy/MM/dd")
    private Date feedbackDate;

    @OneToMany(cascade = CascadeType.ALL,fetch = FetchType.LAZY,mappedBy = "candidateOfferFeedback")
    @JsonManagedReference
    private Set<FeedbackResponse> feedbackResponses;

    public CandidateOffer getCandidateOffer() {
        return candidateOffer;
    }

    public void setCandidateOffer(CandidateOffer candidateOffer) {
        this.candidateOffer = candidateOffer;
    }

    public FeedbackType getFeedbackType() {
        return feedbackType;
    }

    public void setFeedbackType(FeedbackType feedbackType) {
        this.feedbackType = feedbackType;
    }

    public Date getFeedbackDate() {
        return feedbackDate;
    }

    public void setFeedbackDate(Date feedbackDate) {
        this.feedbackDate = feedbackDate;
    }

    public Set<FeedbackResponse> getFeedbackResponses() {
        return feedbackResponses;
    }

    public void setFeedbackResponses(Set<FeedbackResponse> feedbackResponses) {
        this.feedbackResponses = feedbackResponses;
    }
}
