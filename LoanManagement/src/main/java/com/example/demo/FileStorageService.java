package com.example.demo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class FileStorageService {

    @Autowired
    private FileRepository fileRepository;

    // Store a new file
    public FileEntity storeFile(String email, String name, int creditscore, String empstatus, String address, int age,
                                String filename, String filetype, String loanType, byte[] data,String phno) {
        FileEntity fileEntity = new FileEntity(email, name, creditscore, empstatus, address, age, filename, filetype, loanType, data,phno);
        return fileRepository.save(fileEntity);
    }
    public FileEntity getFile(int applicationId) {
        return fileRepository.findById(applicationId)
                .orElseThrow(() -> new RuntimeException("File not found"));
    }
    public FileEntity getFileByEmailAndLoanType(String email,String loanType ) {
        return fileRepository.findByEmailAndLoanType(email,loanType)
                .orElseThrow(() -> new RuntimeException("File not found for the provided email"));
    }

    // Retrieve all loans
    public List<FileEntity> find() {
        return fileRepository.findAll();
    }
    
    
    public boolean isLoanApplicationExists(String email, String loanType) {
        return fileRepository.existsByEmailAndLoanType(email, loanType);
    }
    
    
    public FileEntity updateLoanStatus(String email, String loanType, String status) {
        FileEntity fileEntity = fileRepository.findByEmailAndLoanType(email, loanType)
                .orElseThrow(() -> new RuntimeException("Loan application not found."));
        fileEntity.setStatus(status); // Update the status
        return fileRepository.save(fileEntity); // Save the updated entity
    }
    public List<FileEntity> getLoansByEmail(String email) {
        return fileRepository.findByEmail(email);
    }
    public long countAllLoans() {
        return fileRepository.count();
    }

    
    
    
}
