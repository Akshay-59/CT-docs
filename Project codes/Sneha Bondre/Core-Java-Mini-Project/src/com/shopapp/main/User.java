package com.shopapp.main;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class User {
	public boolean Login() throws ClassNotFoundException{
		Scanner sc = new Scanner(System.in);
		boolean success=false;
		System.out.println("----------MENU----------");
   		System.out.println("1.Admin");
   		System.out.println("2.Customer");
   		System.out.println("0.Exit");
   		System.out.println("Enter Your Role or 0 to Exit");
   		int option = sc.nextInt();
   		if(option==1) {
   			success = isValidUser();
   			if(success==true) {
   				AdminModule adminModule = new AdminModule();
   			}
   			
   		}
   		else if(option==2) {
   			success = isValidCustomer();
   			if(success==true) {
   				CustomerModule customerModule = new CustomerModule(); 
   			}
   			
   			
   		}
   		else{
   			System.out.println("Exited");

   		}
   		return success;
	}
	
	public static boolean isValidUser() throws ClassNotFoundException {
		Scanner sc = new Scanner(System.in);
		//admin username : admin
		System.out.println("Enter Your Username:");
		String username = sc.next();
		//admin password : admin
		System.out.println("Enter Your Password:");
		String password = sc.next();
		boolean isValid=false;
		Statement statement = null;
	    ResultSet resultSet = null;
		String userNameDB = "";
		String passwordDB = "";

		 
		Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
		try {
			Connection con=DriverManager.getConnection("jdbc:sqlserver://CM1VA492\\SQLEXPRESS;databaseName=ImpactMiniProject;user=sa;password=password_123");
			statement = con.createStatement();
	        resultSet = statement.executeQuery("select admin_username,admin_password from AdminDetails");
	        while(resultSet.next())
	        {
	            userNameDB = resultSet.getString("admin_username");
	            passwordDB = resultSet.getString("admin_password");
	 
	            if(username.equals(userNameDB) && password.equals(passwordDB))
	            {
	            	System.out.println("You are Authenticated");
					isValid=true;
	            }
	            else {
	   			 isValid=false;
	   			System.out.println("Wrong username or password");
	   		}
	        }
		
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
	
		return isValid;
	}
	
	public static boolean isValidCustomer() throws ClassNotFoundException {
		Scanner sc = new Scanner(System.in);
		//customer username : cust
		System.out.println("Enter Your Username:");
		String customer_username = sc.next();
	 
		//customer password : cust
		System.out.println("Enter Your Password:");
		String customer_password = sc.next();
		boolean isValid=false;
		Statement statement = null;
	    ResultSet resultSet = null;
		String userNameDBC = "";
		String passwordDBC = "";
		 
		Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
		try {
			Connection con=DriverManager.getConnection("jdbc:sqlserver://CM1VA492\\SQLEXPRESS;databaseName=ImpactMiniProject;user=sa;password=password_123");
			statement = con.createStatement();
	        resultSet = statement.executeQuery("select custmer_username,customer_password from CustomerDetails");
	        while(resultSet.next())
	        {
	            userNameDBC = resultSet.getString("custmer_username");
	            passwordDBC = resultSet.getString("customer_password");
	 
	            if(customer_username.equals(userNameDBC) && customer_password.equals(passwordDBC))
	            {
	            	System.out.println("You are Authenticated");
					isValid=true;
	            }
	            else {
	   			 isValid=false;
	   		}
	        }
		
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
	
		return isValid;
	}
}

