package com.example.demo;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

public interface FileRepository extends JpaRepository<FileEntity,Integer> {
	boolean existsByEmailAndLoanType(String email, String loanType);
	Optional<FileEntity> findByEmailAndLoanType(String email, String loanType);
	 List<FileEntity> findByEmail(String email);
	 long countByStatus(String status);
}
