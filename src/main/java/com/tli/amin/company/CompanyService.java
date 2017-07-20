package com.tli.amin.company;

import com.tli.amin.candidate.Candidate;
import com.tli.amin.enums.IdentificationType;

import java.util.Date;
import java.util.List;

/**
 * Created by KrishnaPrasad on 17/07/2017.
 */
public interface CompanyService {
    Company findById(Long id);

    Company findByName(String name);

    Company saveCompany(Company company);

    void deleteCompanyById(Long id);

    List<Company> findAllCompanies();

    List<Candidate> findCandidates(String firsname, String lastname, IdentificationType identificationType, String idNumber);

    Long offerJobToCandidate(Long companyJobId, Candidate candidate,Date offerDate);

    void sendJobOfferEmail(Long candidateJobOfferId);

}
