package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

@RestController
@CrossOrigin
public class FileUploadController {

    @Autowired
    private FileStorageService fileStorageService;

    @PostMapping("/upload")
    public ResponseEntity<?> uploadFile(
            @RequestParam("file") MultipartFile file,
            @RequestParam("email") String email,
            @RequestParam("name") String name,
            @RequestParam("creditscore") int creditScore,
            @RequestParam("empstatus") String empStatus,
            @RequestParam("address") String address,
            @RequestParam("age") int age,
            @RequestParam("loanType") String loanType,
            @RequestParam("phno")String phno) {
        try {
            // Check if the loan application already exists for the email and loan type
            if (fileStorageService.isLoanApplicationExists(email, loanType)) {
                return ResponseEntity.badRequest().body("Loan application already exists for this loan type.");
            }

            String fileName = name + "." + file.getOriginalFilename().split("\\.")[1];
            String fileType = file.getContentType();
            byte[] data = file.getBytes();

            FileEntity savedFile = fileStorageService.storeFile(email, name, creditScore, empStatus, address, age,
                    fileName, fileType, loanType, data,phno);

            return ResponseEntity.ok(savedFile);

        } catch (IOException e) {
            return ResponseEntity.status(500).body("Error uploading file.");
        }
    }

    @GetMapping("/api/pdf/view/{email}/{loanType}")
    public ResponseEntity<byte[]> viewFileByEmailAndLoanType(@PathVariable String email, @PathVariable String loanType) {
        FileEntity pdfFile = fileStorageService.getFileByEmailAndLoanType(email, loanType);
        return ResponseEntity.ok()
                .contentType(MediaType.APPLICATION_PDF)
                .header(HttpHeaders.CONTENT_DISPOSITION, "inline; filename=\"" + pdfFile.getFilename() + "\"")
                .body(pdfFile.getData());
    }


    
    @GetMapping("/allusers")
    public List<FileEntity> allLoans(){
    	return fileStorageService.find();
    } 
    
    
    
    @PostMapping("/updateStatus")
    public ResponseEntity<String> updateLoanStatus(
            @RequestParam String email,
            @RequestParam String loanType,
            @RequestParam String status) {
        try {
            // Validate the status value
            if (!status.equalsIgnoreCase("Accepted") && !status.equalsIgnoreCase("Rejected")) {
                return ResponseEntity.badRequest().body("Invalid status. Allowed values are 'Accepted' or 'Rejected'.");
            }

            // Update the loan status using the service
            FileEntity updatedLoan = fileStorageService.updateLoanStatus(email, loanType, status);

            return ResponseEntity.ok("Loan status updated to " + updatedLoan.getStatus() + " for loan type: " + updatedLoan.getLoanType());
        } catch (RuntimeException e) {
            return ResponseEntity.status(404).body("Loan application not found for email: " + email + " and loan type: " + loanType);
        } catch (Exception e) {
            return ResponseEntity.status(500).body("Error updating loan status. Please try again.");
        }
    }
    @GetMapping("/userloans")
    public ResponseEntity<List<FileEntity>> getLoansByEmail(@RequestParam String email) {
        System.out.println("Fetching loans for email: " + email); // Debug log
        try {
            List<FileEntity> loans = fileStorageService.getLoansByEmail(email);
            return ResponseEntity.ok(loans);
        } catch (Exception e) {
            return ResponseEntity.status(500).body(null);
        }
    }
    @GetMapping("/loanCounts")
    public ResponseEntity<Long> getLoanCount() {
        try {
            long count = fileStorageService.countAllLoans();
            return ResponseEntity.ok(count);
        } catch (Exception e) {
            return ResponseEntity.status(500).body(0L);  // Return 0 in case of an error
        }
    }
    
   
    
    
   
}
