package com.hexaware.loanmanagement.codingchallenge.bean;

public class CarLoan extends Loan{
	private int carValue;
	private  String carModel;
	public CarLoan(int loanId,Customer customer,long principalAmount, double interestRate,int loanTerm,String loanType,String loanStatus,int carValue,String carModel) {
		super(loanId,customer,principalAmount,interestRate,loanTerm,loanType,loanStatus);
		 this.carModel=carModel;
		 this.carValue=carValue;
	}
	public int getCarValue() {
		return carValue;
	}
	public void setCarValue(int carValue) {
		this.carValue = carValue;
	}
	public String getCarModel() {
		return carModel;
	}
	public void setCarModel(String carModel) {
		this.carModel = carModel;
	}
	public void printdetails() {
		System.out.println("car model"+carModel);
		System.out.println("car value"+carValue);
	}
}
