package com.example.loanmanagement.service;

import com.example.loanmanagement.entity.Enquiry;

import java.util.List;
import java.util.Optional;

public interface EnquiryService {

    List<Enquiry> getAllEnquiries();

    Optional<Enquiry> getEnquiryById(Long id);

    Enquiry createEnquiry(Enquiry enquiry);

    Optional<Enquiry> updateEnquiry(Long id, Enquiry enquiryDetails);

    void deleteEnquiry(Long id);
}
