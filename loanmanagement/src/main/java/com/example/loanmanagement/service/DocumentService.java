package com.example.loanmanagement.service;


import com.example.loanmanagement.entity.*;
import com.example.loanmanagement.repository.DocumentRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

@Service
public class DocumentService {

    @Autowired
    private DocumentRepository documentRepository;

    public Document saveDocument(MultipartFile file, DocumentType documentType) throws IOException {
        String fileName = file.getOriginalFilename();
        String fileType = file.getContentType();
        Document document = new Document(fileName, fileType, documentType, file.getBytes());
        return documentRepository.save(document);
    }

    public Document getDocument(Long id) {
        return documentRepository.findById(id).orElse(null);
    }

    public List<Document> getAllDocuments() {
        return documentRepository.findAll();
    }
}

