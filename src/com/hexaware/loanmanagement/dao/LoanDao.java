package com.hexaware.loanmanagement.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
//import java.sql.*;

import com.hexaware.loanmanagement.codingchallenge.bean.Customer;
import com.hexaware.loanmanagement.codingchallenge.bean.Loan;
import com.hexaware.loanmanagement.codingchallenge.service.ILoanRepository;
import com.hexaware.loanmanagement.exception.InvalidLoanException;
import com.hexaware.loanmanagement.util.DBUtil;



public class LoanDao implements ILoanRepository {
	
@Override
public String applyLoan(Loan loan) {
	String query="insert into Loan values(?,?,?,?,?,?,?)";
	try(Connection con=(Connection) DBUtil.getConnection();
			PreparedStatement stmt=con.prepareStatement(query)){
		
		loan.setLoanStatus("pending");
		stmt.setInt(1, loan.getLoanId());
		stmt.setInt(2,loan.getCustomer().getCustomerId());
		stmt.setLong(3,loan.getPrincipalAmount());
		stmt.setDouble(4,loan.getInterestRate());
		stmt.setInt(5,loan.getLoanTerm());
		stmt.setString(6,loan.getLoanType());
		stmt.setString(7,loan.getLoanStatus());
		int rs=stmt.executeUpdate();
		if(rs>0) {
			
			return "loan is applied";
		}
		else {
			return "loan is not applied";
		}
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	// TODO Auto-generated method stub
	return "error database not connected";
	
}

	// TODO Auto-generated method stub
	

@Override
public double calculateInterest(int loanId) throws InvalidLoanException{
	String query="select principalAmount,interestrate,Loanterm from Loan where loanId=? ";
	try(Connection con=(Connection) DBUtil.getConnection();
			PreparedStatement stmt=con.prepareStatement(query)){
		stmt.setInt(1, loanId);
		ResultSet rs=stmt.executeQuery();
		if(rs.next()) {
			
			double rate=rs.getDouble("interestrate");
			int term=rs.getInt("loanterm");
			long p=rs.getInt("principalAmount");
			double interestamount=(double) (rate*p*term/12);
			return interestamount;
		
		
		}
		else {
			throw new InvalidLoanException("error");
		}
	}
	
	catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}

	// TODO Auto-generated method stub
	return 0;
}

@Override
public String loanStatus(int loanId) {
	String query="select c.creditscore from Customer c join Loan l on l.CustomerID=c.CustomerID where loanid=?";
		String query2="update loan set loanstatus=? where loanid=?;";
	// TODO Auto-generated method stub
			try(Connection con=(Connection) DBUtil.getConnection();
				PreparedStatement stmt=con.prepareStatement(query);
					PreparedStatement stmt2=con.prepareStatement(query2)){
					stmt.setInt(1, loanId);
					
					ResultSet rs=stmt.executeQuery();
					//int rs=stmt.executeUpdate();
					if(rs.next()) {
						int creditscore=rs.getInt("creditscore");
						String status=creditscore>650?"approved":"rejected" ;
							
							
							stmt2.setString(1,status);
							stmt2.setInt(2, loanId);
							stmt2.executeUpdate();
							return status;
						}
						
						
						//rs.setInt("loanStatus");
						//return status;
					}
					
				
			
	catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	return "error";

	
}
	// TODO Auto-generated method stub
	

@Override
public double calculateEMI(int loanId) throws InvalidLoanException {
	String query="select principalAmount,interestrate,loanterm from Loan where LoanId=?";
	try(Connection con=(Connection) DBUtil.getConnection();
			PreparedStatement stmt=con.prepareStatement(query)){
		stmt.setInt(1,loanId);
		ResultSet rs=stmt.executeQuery();
		if(rs.next()) {
			double p=rs.getDouble("principalAmount");
			double rate=rs.getDouble("interestrate")/12/100;
			int n=rs.getInt("loanterm");
			double emi=(p*rate*Math.pow(1+rate,n))/(Math.pow(1+rate, n)-1);
			return emi;
		}
		else {
			throw new InvalidLoanException("error");
		}
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	// TODO Auto-generated method stub
	return 0;
}

@Override
public int loanRepayment(int loanId, double amount) {
	String query="select principalamount,interestrate,loanterm from Loan where LoanId=?";
	try(Connection con=(Connection) DBUtil.getConnection();
			PreparedStatement stmt=con.prepareStatement(query)){
		stmt.setInt(1, loanId);
		ResultSet rs=stmt.executeQuery();
		if(rs.next()) {
			double p=rs.getDouble("principalAmount");
			double rate=rs.getDouble("interestrate")/12/100;
			int n=rs.getInt("loanterm");
			double emi=(p*rate*Math.pow(1+rate,n))/(Math.pow(1+rate, n)-1);
			//stmt.setDouble(2, emi);
			if(emi>amount) {
				System.out.println("amount is rejected");
				return 0;
			}
			else {
				int count=(int) (amount/emi);
				System.out.println("amount is accepted");
				
			
			return count;
			}
			
		}
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	// TODO Auto-generated method stub
	return 0;
}

@Override
public List<Loan> getAllLoan() {
	String query="select * from Loan";
	List<Loan> loanlist=new ArrayList<>();
	try(Connection con=(Connection) DBUtil.getConnection()){
		Statement stmt=con.createStatement();
		ResultSet rs=stmt.executeQuery(query);
		while(rs.next()) {
			Loan l=new Loan();
			Customer c=new Customer();
			c.setCustomerId(rs.getInt("CustomerID"));
			l.setCustomer(c);
			l.setLoanId(rs.getInt("loanId"));
			//l.setCustomer().setCustomer((rs.getInt("CustomerID"));
			l.setPrincipalAmount(rs.getLong("Principalamount"));
			l.setInterestRate(rs.getDouble("interestrate"));
			l.setLoanTerm(rs.getInt("loanterm"));
			l.setLoanType(rs.getString("loantype"));
			l.setLoanStatus(rs.getString("loanstatus"));
			loanlist.add(l);
			
		}
	}
		catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
				
			
	// TODO Auto-generated method stub
	



	// TODO Auto-generated method stub
	return loanlist;
}

@Override
public List<Loan> getLoanById(int loanId) throws InvalidLoanException{
	List<Loan> loanlist=new ArrayList<>();
	String query="select * from Loan where loanId=?";
	try(Connection con=(Connection) DBUtil.getConnection();
			PreparedStatement stmt=con.prepareStatement(query)){
		
		stmt.setInt(1, loanId);
		ResultSet rs=stmt.executeQuery();
		if(rs.next()) {
			Loan l=new Loan();
			Customer c=new Customer();
			c.setCustomerId(rs.getInt("CustomerID"));
			l.setCustomer(c);
			l.setLoanId(rs.getInt("loanId"));
			//l.setCustomer().setCustomer((rs.getInt("CustomerID"));
			l.setPrincipalAmount(rs.getLong("Principalamount"));
			l.setInterestRate(rs.getDouble("interestrate"));
			l.setLoanTerm(rs.getInt("loanterm"));
			l.setLoanType(rs.getString("loantype"));
			l.setLoanStatus(rs.getString("loanstatus"));
			loanlist.add(l);
			
			
		}
		else {
			throw new InvalidLoanException("error");
		}
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	// TODO Auto-generated method stub
	return loanlist;


	// TODO Auto-generated method stub
	
}
}