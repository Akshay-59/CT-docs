package com.shopapp.main;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class Customer {
	Scanner input = new Scanner(System.in);
	public void addCustomer() throws ClassNotFoundException {
		Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
		try {
			Connection con=DriverManager.getConnection("jdbc:sqlserver://CM1VA492\\SQLEXPRESS;databaseName=ImpactMiniProject;user=sa;password=password_123");
			System.out.println("Connected");
			PreparedStatement pstmt = con.prepareStatement("insert into CustomerDetails values (?,?,?)");
		    System.out.println("Enter the ID of Customer to be added");
			int customer_id=input.nextInt();
			System.out.println("Enter the username of customer");
			String custmer_username=input.next();
			System.out.println("Enter the password of customer");
			String customer_password=input.next();
			
			pstmt.setInt(1, customer_id);
			pstmt.setString(2, custmer_username);
			pstmt.setString(3, customer_password);
			
			pstmt.executeUpdate();
			System.out.println("Customer is added");
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
	}
	public void updateCustomer() throws ClassNotFoundException {
		Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
		try {
			Connection con=DriverManager.getConnection("jdbc:sqlserver://CM1VA492\\SQLEXPRESS;databaseName=ImpactMiniProject;user=sa;password=password_123");
			System.out.println("Connected");
			PreparedStatement pstmt = con.prepareStatement("update CustomerDetails set custmer_username=? where customer_id=? ");
			System.out.println("Enter the Id of Customer to be updated");
			int customer_id=input.nextInt();
			System.out.println("Enter the Name of Customer ");
			String custmer_username=input.next();
			
			pstmt.setString(1, custmer_username);
			pstmt.setInt(2, customer_id);
			pstmt.executeUpdate();
			System.out.println("Customer details updated");
			
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
	}
	public void deleteCustomer() throws ClassNotFoundException{
		Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
		try {
			Connection con=DriverManager.getConnection("jdbc:sqlserver://CM1VA492\\SQLEXPRESS;databaseName=ImpactMiniProject;user=sa;password=password_123");
			System.out.println("Connected");
			PreparedStatement pstmt = con.prepareStatement("delete from CustomerDetails where customer_id=? ");
			System.out.println("Enter the Id of Customer to be deleted");
			int customer_id=input.nextInt();
			pstmt.setInt(1, customer_id);
			pstmt.executeUpdate();
			System.out.println("Customer Deleted Successfully");
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}

	}
	public void getCustomerById() throws ClassNotFoundException {
		Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
		try {
			Connection con=DriverManager.getConnection("jdbc:sqlserver://CM1VA492\\SQLEXPRESS;databaseName=ImpactMiniProject;user=sa;password=password_123");
			System.out.println("Connected");
			PreparedStatement pstmt = con.prepareStatement("select * from CustomerDetails where customer_id=? ");
			System.out.println("Enter the ID of Customer");
			int customer_id=input.nextInt();
			pstmt.setInt(1, customer_id);
			
			ResultSet rs = pstmt.executeQuery();
			while(rs.next()) {
			System.out.println(rs.getInt("customer_id")+"--"+rs.getString(2)+"--"+rs.getString(3));
			}
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
		
	}
	public void getAllCustomer() throws ClassNotFoundException {
		Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
		try {
			Connection con=DriverManager.getConnection("jdbc:sqlserver://CM1VA492\\SQLEXPRESS;databaseName=ImpactMiniProject;user=sa;password=password_123");
			System.out.println("This is the list of Customer");
			PreparedStatement pstmt = con.prepareStatement("select * from CustomerDetails");
			
			ResultSet rs = pstmt.executeQuery();
			while(rs.next()) {
				System.out.println(rs.getInt(1)+"--"+rs.getString(2)+"--"+rs.getString(3));
			}
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
		
	}
}
