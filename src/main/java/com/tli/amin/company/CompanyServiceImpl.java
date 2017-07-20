package com.tli.amin.company;

import com.tli.amin.candidate.*;
import com.tli.amin.enums.IdentificationType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

/**
 * Created by KrishnaPrasad on 17/07/2017.
 */
@Service
public class CompanyServiceImpl implements CompanyService{
    @Autowired
    private CompanyRepository companyRepository;

    @Autowired
    private CompanyJobsRepository companyJobOfferRepository;

    @Autowired
    private CandidateOfferRepository candidateJobOfferRepository;

    @Autowired
    private CandidateRepository candidateRepository;

    @Override
    public Company findById(Long id) {
        return companyRepository.findOne(id);
    }

    @Override
    public Company findByName(String name) {
        return companyRepository.findByCompanyName(name);
    }

    @Override
    public Company saveCompany(Company company) {
        companyRepository.save(company);
        return company;
    }

    @Override
    public void deleteCompanyById(Long id) {
        Company company = companyRepository.findOne(id);
        companyRepository.delete(company);

    }

    @Override
    public List<Company> findAllCompanies() {
        return companyRepository.findAll();
    }

    @Override
    public Long offerJobToCandidate(Long companyJobOfferId, Candidate candidate,Date offerDate) {
        CompanyJobOffer companyJobOffer = companyJobOfferRepository.findOne(companyJobOfferId);
        CandidateOffer candidateOffer = new CandidateOffer();
        candidateRepository.save(candidate);
        candidateOffer.setCandidate(candidate);
        candidateOffer.setOfferDate(offerDate);
        candidateOffer.setCompanyJobOffer(companyJobOffer);
        candidateJobOfferRepository.save(candidateOffer);
        return candidateOffer.getId();
    }

    public void sendJobOfferEmail(Long candidateJobOfferId){
        // send job offer email to the candidate
    }

    @Override
    public List<Candidate> findCandidates(String firsname, String lastname, IdentificationType identificationType, String idNumber){
        candidateRepository.findAll();
        return null;
    }
}
