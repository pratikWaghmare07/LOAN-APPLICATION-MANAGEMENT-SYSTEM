package com.example.loanmanagement.repository;

import com.example.loanmanagement.entity.Document;
import com.example.loanmanagement.entity.DocumentType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DocumentRepository extends JpaRepository<Document, Long> {

    List<Document> findByDocumentType(DocumentType documentType);

    // Add more custom queries as needed
}
