package com.tli.amin.candidate;

import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by KrishnaPrasad on 18/07/2017.
 */
public interface CandidateJobOfferRepository extends JpaRepository<CandidateOffer,Long> {
}
