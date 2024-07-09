package com.example.loanmanagement.service;

import com.example.loanmanagement.entity.Enquiry;
import com.example.loanmanagement.repository.EnquiryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EnquiryServiceImpl implements EnquiryService {

    @Autowired
    private EnquiryRepository enquiryRepository;

    @Override
    public List<Enquiry> getAllEnquiries() {
        return enquiryRepository.findAll();
    }

    @Override
    public Optional<Enquiry> getEnquiryById(Long id) {
        return enquiryRepository.findById(id);
    }

    @Override
    public Enquiry createEnquiry(Enquiry enquiry) {
        return enquiryRepository.save(enquiry);
    }

    @Override
    public Optional<Enquiry> updateEnquiry(Long id, Enquiry enquiryDetails) {
        return enquiryRepository.findById(id).map(enquiry -> {
            enquiry.setName(enquiryDetails.getName());
            enquiry.setAddress(enquiryDetails.getAddress());
            enquiry.setLoanPurpose(enquiryDetails.getLoanPurpose());
            enquiry.setLoanAmount(enquiryDetails.getLoanAmount());
            enquiry.setEmail(enquiryDetails.getEmail());
            enquiry.setPhoneNumber(enquiryDetails.getPhoneNumber());
            enquiry.setPancard(enquiryDetails.getPancard());
            return enquiryRepository.save(enquiry);
        });
    }

    @Override
    public void deleteEnquiry(Long id) {
        enquiryRepository.findById(id).ifPresent(enquiryRepository::delete);
    }
}
