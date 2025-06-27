package com.hexaware.loanmanagement.util;
import java.sql.*;

//import com.sun.jdi.connect.spi.Connection;

//import com.sun.jdi.connect.spi.Connection;
public class DBUtil {
	public static Connection con;
	public static Connection getConnection() {
		if(con==null) {
			try {
			con=(Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/loanmanagement","root","saravana");
			
		}
			catch(Exception e){
				e.printStackTrace();
			}
	}
		return con;
		
	}
	public static void closeConnection() {
		try {
			con.close();
		}
		catch(Exception e){
			e.printStackTrace();
		}
	}


}
