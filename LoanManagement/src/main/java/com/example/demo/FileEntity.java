package com.example.demo;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Lob;

@Entity
public class FileEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int applicationid;
    private String email;
    private String name;
    private int creditscore;
    private String empstatus;
    private String address;
    private int age;
    private String filename;
    private String filetype;
    private String loanType; 
    private String phno;

    @Lob
    private byte[] data;
    private String status="Pending";
    public FileEntity() {
    }

    public FileEntity(String email,String name, int creditscore, String empstatus, String address, int age,
                      String filename, String filetype, String loanType, byte[] data,String phno) {
    	this.email=email;
        this.name = name;
        this.creditscore = creditscore;
        this.empstatus = empstatus;
        this.address = address;
        this.age = age;
        this.filename = filename;
        this.filetype = filetype;
        this.loanType = loanType;
        this.data = data;
        this.phno=phno;
    }

    // Getters and Setters
    
    public int getApplicationid() {
        return applicationid;
    }

    public String getPhno() {
		return phno;
	}

	public void setPhno(String phno) {
		this.phno = phno;
	}
	public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public void setApplicationid(int applicationid) {
        this.applicationid = applicationid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getCreditscore() {
        return creditscore;
    }

    public void setCreditscore(int creditscore) {
        this.creditscore = creditscore;
    }

    public String getEmpstatus() {
        return empstatus;
    }

    public void setEmpstatus(String empstatus) {
        this.empstatus = empstatus;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getFilename() {
        return filename;
    }

    public void setFilename(String filename) {
        this.filename = filename;
    }

    public String getFiletype() {
        return filetype;
    }

    public void setFiletype(String filetype) {
        this.filetype = filetype;
    }

    public String getLoanType() {
        return loanType;
    }

    public void setLoanType(String loanType) {
        this.loanType = loanType;
    }

    public byte[] getData() {
        return data;
    }

    public void setData(byte[] data) {
        this.data = data;
    }
}
