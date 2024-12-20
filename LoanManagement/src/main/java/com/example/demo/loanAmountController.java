package com.example.demo;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

@RestController
@CrossOrigin
public class loanAmountController {
	@Autowired
	private loanAmountService las;
	 @PostMapping("/loan/upload")
	    public ResponseEntity<?> uploadLoanApplication(
	            @RequestParam("fullname") String fullname,
	            @RequestParam("loanamount") String loanamount,
	            @RequestParam("tenure") int tenure,
	            @RequestParam("identity") MultipartFile identity,
	            @RequestParam("signature") MultipartFile signature) {
	        try {
	            // Process identity file
	            String identityFilename = identity.getOriginalFilename();
	            String identityFiletype = identity.getContentType();
	            byte[] identityData = identity.getBytes();

	            // Process signature file
	            String signatureFilename = signature.getOriginalFilename();
	            String signatureFiletype = signature.getContentType();
	            byte[] signatureData = signature.getBytes();

	            // Save loan application
	            loanamountentity loanApplication = las.saveLoanApplication(
	                    fullname, loanamount, tenure, identityData, identityFilename, identityFiletype,
	                    signatureData, signatureFilename, signatureFiletype);

	            return ResponseEntity.ok(loanApplication);

	        } catch (IOException e) {
	            return ResponseEntity.status(500).body("Error uploading files. Please try again.");
	        }
	    }
	
}
