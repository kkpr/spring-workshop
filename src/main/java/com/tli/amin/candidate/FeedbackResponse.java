package com.tli.amin.candidate;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

/**
 * Created by KrishnaPrasad on 17/07/2017.
 */
@Entity
public class FeedbackResponse {

    private CandidateOfferFeedback candidateOfferFeedback;

    @OneToOne
    @JoinColumn(name="job_motive_id")
    private JobMotive jobMotive;
    private String jobMotiveResponse;

    public CandidateOfferFeedback getCandidateOfferFeedback() {
        return candidateOfferFeedback;
    }

    public void setCandidateOfferFeedback(CandidateOfferFeedback candidateOfferFeedback) {
        this.candidateOfferFeedback = candidateOfferFeedback;
    }

    public JobMotive getJobMotive() {
        return jobMotive;
    }

    public void setJobMotive(JobMotive jobMotive) {
        this.jobMotive = jobMotive;
    }

    public String getJobMotiveResponse() {
        return jobMotiveResponse;
    }

    public void setJobMotiveResponse(String jobMotiveResponse) {
        this.jobMotiveResponse = jobMotiveResponse;
    }
}
