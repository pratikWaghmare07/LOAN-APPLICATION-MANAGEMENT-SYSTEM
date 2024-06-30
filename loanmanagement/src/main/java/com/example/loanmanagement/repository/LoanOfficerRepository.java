package com.example.loanmanagement.repository;

import com.example.loanmanagement.entity.LoanOfficer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LoanOfficerRepository extends JpaRepository<LoanOfficer, Long> {
    LoanOfficer findByUsername(String username);


	boolean existsByUsername(String username);
}
