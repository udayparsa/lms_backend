package com.example.demo;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Lob;

@Entity
public class loanamountentity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int loanId;

    private String fullname;
    private String loanamount;
    private int tenure;

    @Lob
    private byte[] identityProof;

    private String identityFilename;
    private String identityFiletype;

    @Lob
    private byte[] signature;

    private String signatureFilename;
    private String signatureFiletype;

    private String status = "Pending";

    public loanamountentity() {
    }

    public loanamountentity(String fullname, String loanamount, int tenure,
                            byte[] identityProof, String identityFilename, String identityFiletype,
                            byte[] signature, String signatureFilename, String signatureFiletype) {
        this.fullname = fullname;
        this.loanamount = loanamount;
        this.tenure = tenure;
        this.identityProof = identityProof;
        this.identityFilename = identityFilename;
        this.identityFiletype = identityFiletype;
        this.signature = signature;
        this.signatureFilename = signatureFilename;
        this.signatureFiletype = signatureFiletype;
    }

    // Getters and Setters

    public int getLoanId() {
        return loanId;
    }

    public void setLoanId(int loanId) {
        this.loanId = loanId;
    }

    public String getFullname() {
        return fullname;
    }

    public void setFullname(String fullname) {
        this.fullname = fullname;
    }

    public String getLoanamount() {
        return loanamount;
    }

    public void setLoanamount(String loanamount) {
        this.loanamount = loanamount;
    }

    public int getTenure() {
        return tenure;
    }

    public void setTenure(int tenure) {
        this.tenure = tenure;
    }
    public byte[] getIdentityProof() {
        return identityProof;
    }

    public void setIdentityProof(byte[] identityProof) {
        this.identityProof = identityProof;
    }

    public String getIdentityFilename() {
        return identityFilename;
    }

    public void setIdentityFilename(String identityFilename) {
        this.identityFilename = identityFilename;
    }

    public String getIdentityFiletype() {
        return identityFiletype;
    }

    public void setIdentityFiletype(String identityFiletype) {
        this.identityFiletype = identityFiletype;
    }

    public byte[] getSignature() {
        return signature;
    }

    public void setSignature(byte[] signature) {
        this.signature = signature;
    }

    public String getSignatureFilename() {
        return signatureFilename;
    }

    public void setSignatureFilename(String signatureFilename) {
        this.signatureFilename = signatureFilename;
    }

    public String getSignatureFiletype() {
        return signatureFiletype;
    }

    public void setSignatureFiletype(String signatureFiletype) {
        this.signatureFiletype = signatureFiletype;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
