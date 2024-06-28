package com.example.loanmanagement.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.loanmanagement.entity.Borrower;
import com.example.loanmanagement.entity.User;
import com.example.loanmanagement.repository.BorrowerRepository;
import java.util.List;

@Service
public class BorrowerService {

    @Autowired
    private BorrowerRepository borrowerRepository;

    public Borrower registerBorrower(Borrower borrower) {
        return borrowerRepository.save(borrower);
    }
    
    

    public Borrower getBorrowerById(Long id) {
        return borrowerRepository.findById(id).orElse(null);
    }

    public List<Borrower> getAllBorrowers() {
        return borrowerRepository.findAll();
    }

    public void deleteBorrower(Long id) {
        borrowerRepository.deleteById(id);
    }
}
