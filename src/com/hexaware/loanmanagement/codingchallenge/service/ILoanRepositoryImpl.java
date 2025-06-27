package com.hexaware.loanmanagement.codingchallenge.service;

import java.util.ArrayList;
import java.util.List;

import com.hexaware.loanmanagement.codingchallenge.bean.Loan;
import com.hexaware.loanmanagement.dao.LoanDao;
import com.hexaware.loanmanagement.exception.InvalidLoanException;

public class ILoanRepositoryImpl implements ILoanRepository{
  LoanDao dao=new LoanDao();
	@Override
	public String applyLoan(Loan loan) {
		String s=dao.applyLoan(loan);
		
		// TODO Auto-generated method stub
		return s;
	}

	@Override
	public double calculateInterest(int loanId) throws InvalidLoanException {
		// TODO Auto-generated method stub
		double interestrate=dao.calculateInterest(loanId);
		
		return interestrate;
	}

	@Override
	public String loanStatus(int loanId) {
		String status=dao.loanStatus(loanId);
		// TODO Auto-generated method stub
		return status;
	}

	@Override
	public double calculateEMI(int loanId) {
		double emi = 0;
		try {
			emi = dao.calculateEMI(loanId);
		} catch (InvalidLoanException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		// TODO Auto-generated method stub
		return emi;
	}

	@Override
	public int loanRepayment(int loanId, double amount) {
		
		// TODO Auto-generated method stub
		int count=dao.loanRepayment(loanId, amount);
		
		return count;
	}

	@Override
	public List<Loan> getAllLoan() {
		List<Loan> loanlist=new ArrayList<>();
		loanlist=dao.getAllLoan();
		// TODO Auto-generated method stub
		return loanlist;
	}

	@Override
	public List<Loan> getLoanById(int loanId) {
		List<Loan> loanlist=new ArrayList<>();
		try {
			loanlist=dao.getLoanById(loanId);
		} catch (InvalidLoanException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		// TODO Auto-generated method stub
		return loanlist;
	}

}
