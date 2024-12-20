package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class loanAmountService {
	@Autowired
	private loanamountrepository lar;
	 public loanamountentity saveLoanApplication(String fullname, String loanamount, int tenure,
             byte[] identityProof, String identityFilename, String identityFiletype,
             byte[] signature, String signatureFilename, String signatureFiletype) {
		 loanamountentity loanAmountEntity = new loanamountentity(fullname, loanamount, tenure, identityProof, identityFilename, identityFiletype,signature, signatureFilename, signatureFiletype);
return lar.save(loanAmountEntity);
}

}
