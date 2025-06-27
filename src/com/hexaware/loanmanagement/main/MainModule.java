package com.hexaware.loanmanagement.main;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.hexaware.loanmanagement.codingchallenge.bean.Customer;
import com.hexaware.loanmanagement.codingchallenge.bean.Loan;
import com.hexaware.loanmanagement.dao.LoanDao;
import com.hexaware.loanmanagement.exception.InvalidLoanException;

public class MainModule {
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		
		LoanDao dao=new LoanDao();
		System.out.println("1.apply loan");
		System.out.println("2.calculate interest");
		System.out.println("3.loan status");
		System.out.println("4.calculate emi");
		System.out.println("5.loan repayment");
		System.out.println("6.get all loan");
		System.out.println("7.get loan by id");
		System.out.println("8.exit");
		int opt=sc.nextInt();
		switch(opt) {
		case 1:
		
		while (true) {
			System.out.println("enter the customer id");
			int custid=sc.nextInt();
			System.out.println("enter the customer name");
			String name=sc.next();
			System.out.println("enter the customer email");
			String email=sc.next();
			System.out.println("enter the customer phone");
			String phone=sc.next();
			System.out.println("enter the customer address");
			String Address=sc.next();
			System.out.println("enter the customer credit");
			int credit=sc.nextInt();
			Customer c=new Customer(custid,name,email,phone,Address,credit);
			System.out.println("enter loan id");
			int id=sc.nextInt();
			
			System.out.println("enter principalamount");
			long amount=sc.nextLong();
			System.out.println("enter interestrate");
			double rate=sc.nextDouble();
			System.out.println("enter loan term");
			int term=sc.nextInt();
			System.out.println("enter loan type");
			String type=sc.next();
			System.out.println("enter loan status");
			String status=sc.next();
			Loan l=new Loan(id,c,amount,rate,term,type,status);
			String confirm=sc.next();
			if(confirm.equals("yes")) {
			String s=dao.applyLoan(l);
			System.out.println(s);
			}
			else {
              System.out.println("loan application is not applied");
			}
			break;
		}
		case 2:
			System.out.println("enter the  id");
			int id1=sc.nextInt();
			double interest = 0;
			try {
				interest = dao.calculateInterest(id1);
			} catch (InvalidLoanException e) {
				System.out.println("invalid loan"+e.getMessage());
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			System.out.println(interest);
			break;
			
		case 3:
			System.out.println("enter the  id");
			int id2=sc.nextInt();
			String s=dao.loanStatus(id2);
			System.out.println(s);
			break;
		case 4:
			System.out.println("enter the  id");
			int id3=sc.nextInt();
			double emi = 0;
			try {
				emi = dao.calculateEMI(id3);
			} catch (InvalidLoanException e) {
				System.out.println("invalid loan"+e.getMessage());
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			System.out.println(emi);
			break;
		case 5:
			System.out.println("enter the  id");
			int id4=sc.nextInt();
			System.out.println("enter the amount");
			double amount = sc.nextDouble();
			int count=dao.loanRepayment(id4, amount);
			try {
				amount = sc.nextDouble();
			} catch (Exception e) {
				System.out.println("invalid loan"+e.getMessage());
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			System.out.println(count);
			break;
		case 6:
			List<Loan>loanList=new ArrayList<>();
			loanList=dao.getAllLoan();
			for(Loan l:loanList) {
			System.out.println(loanList);
			}
			break;
		case 7:
			System.out.println("enter the id");
			int id5=sc.nextInt();
			List<Loan>loanList1=new ArrayList<>();
			
			try {
				loanList1=dao.getLoanById(id5);
				for(Loan l:loanList1) {
				System.out.println(l);
				}
			} catch (InvalidLoanException e) {
				System.out.println("invalid loan"+e.getMessage());
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			break;
		case 8:
			System.exit(1);
			default:
				System.out.println("invalid");
		
	}

	}
}
