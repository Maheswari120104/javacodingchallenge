package com.hexaware.loanmanagement.codingchallenge.service;

import java.util.List;

import com.hexaware.loanmanagement.codingchallenge.bean.Loan;
import com.hexaware.loanmanagement.exception.InvalidLoanException;

public interface ILoanRepository {
	String applyLoan(Loan loan);
	double calculateInterest(int loanId) throws InvalidLoanException;
	String loanStatus(int loanId);
	double calculateEMI(int loanId) throws InvalidLoanException;
	int loanRepayment(int loanId,double amount);
	List<Loan> getAllLoan();
	List<Loan> getLoanById(int loanId) throws InvalidLoanException;

}
