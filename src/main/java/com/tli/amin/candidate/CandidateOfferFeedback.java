package com.tli.amin.candidate;

import com.tli.amin.model.BaseEntity;

import javax.persistence.*;
import java.util.Date;

/**
 * Created by KrishnaPrasad on 17/07/2017.
 */
@Entity
public class CandidateOfferFeedback extends BaseEntity{

    @ManyToOne
    @JoinColumn(name = "candidate_job_offer_id")
    private CandidateOffer candidateJobOffer;

    @Enumerated(EnumType.STRING)
    @Column(name = "feedback_type")
    private FeedbackType feedbackType;
    private Date feedbackDate;
    private FeedbackResponse feedbackResponse;

    public CandidateOffer getCandidateJobOffer() {
        return candidateJobOffer;
    }

    public void setCandidateJobOffer(CandidateOffer candidateJobOffer) {
        this.candidateJobOffer = candidateJobOffer;
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

    public FeedbackResponse getFeedbackResponse() {
        return feedbackResponse;
    }

    public void setFeedbackResponse(FeedbackResponse feedbackResponse) {
        this.feedbackResponse = feedbackResponse;
    }
}
