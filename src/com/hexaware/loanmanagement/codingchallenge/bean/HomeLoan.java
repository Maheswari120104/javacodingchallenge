package com.hexaware.loanmanagement.codingchallenge.bean;

public class HomeLoan extends Loan {
	private int propertyValue;
	private String propertyAddress;
	public HomeLoan(int loanId,Customer customer,long principalAmount, double interestRate,int loanTerm,String loanType,String loanStatus,String propertyAdress,int propertyValue, String propertyAddress) {
		super(loanId,customer,principalAmount,interestRate,loanTerm,loanType,loanStatus);
		this.propertyAddress=propertyAddress;
		this.propertyValue=propertyValue;
	}
	public int getPropertyValue() {
		return propertyValue;
	}
	public void setPropertyValue(int propertyValue) {
		this.propertyValue = propertyValue;
	}
	public String getPropertyAddress() {
		return propertyAddress;
	}
	public void setPropertyAddress(String propertyAddress) {
		this.propertyAddress = propertyAddress;
	}
	public void printDetails(){
		System.out.println("property address"+propertyAddress);
		System.out.println("property value"+propertyValue);
		
	}

}
