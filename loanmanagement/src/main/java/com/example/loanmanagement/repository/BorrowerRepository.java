package com.example.loanmanagement.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.example.loanmanagement.entity.Borrower;
import com.example.loanmanagement.entity.User;

@Repository
public interface BorrowerRepository extends JpaRepository<Borrower, Long> {

}
