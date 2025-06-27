package com.hexaware.loanmanagement.codingchallenge.bean;

public class Loan {
	private int loanId;
	private Customer customer;
	private long principalAmount;
	private double interestRate;
	private int loanTerm;
	private String loanType;
	private String loanStatus;
	
	public Loan(int loanId,Customer customer,long principalAmount, double interestRate,int loanTerm,String loanType,String loanStatus) {
		this.loanId=loanId;
		this.customer= customer;
		this.principalAmount=principalAmount;
		this.interestRate= interestRate;
		this.loanTerm=loanTerm;
		this.loanType=loanType;  
		this.loanStatus= loanStatus;
	}
	public Loan() {
		this.loanId=0;
		this.customer= new Customer();
		this.principalAmount=0;
		this.interestRate=0;
		this.loanTerm=0;
		this.loanType="";  
		this.loanStatus="";
	}
	public int getLoanId() {
		return loanId;
	}
	public void setLoanId(int loanId) {
		this.loanId = loanId;
	}
	public Customer getCustomer() {
		return customer;
	}
	public void setCustomer(Customer customer) {
		this.customer = customer;
	}
	public long getPrincipalAmount() {
		return principalAmount;
	}
	public void setPrincipalAmount(long principalAmount) {
		this.principalAmount = principalAmount;
	}
	public double getInterestRate() {
		return interestRate;
	}
	public void setInterestRate(double interestRate) {
		this.interestRate = interestRate;
	}
	public int getLoanTerm() {
		return loanTerm;
	}
	public void setLoanTerm(int loanTerm) {
		this.loanTerm = loanTerm;
	}
	public String getLoanType() {
		return loanType;
	}
	public void setLoanType(String loanType) {
		this.loanType = loanType;
	}
	public String getLoanStatus() {
		return loanStatus;
	}
	public void setLoanStatus(String loanStatus) {
		this.loanStatus = loanStatus;
	}
	public void printDetails() {
		System.out.println("LoanID:"+getLoanId());
		System.out.println("customer:"+getCustomer());
		System.out.println("principalAmount:"+getPrincipalAmount());
		System.out.println("interestRate:"+getInterestRate());
		System.out.println("loanterm:"+getLoanTerm());
		System.out.println("loan type:"+getLoanType());
		System.out.println("loan status:"+getLoanStatus());
	}
	public String toString() {
		return "id: "+loanId+"\n"+"customer: "+customer+"\n"+"amount: "+
	principalAmount+"\n"+"interestrate: "+interestRate+"\n"+"loanterm: "+loanTerm+"\n"+
	"loantype: "+loanType+"\n"+"status: "+loanStatus+"\n";
	}

}
