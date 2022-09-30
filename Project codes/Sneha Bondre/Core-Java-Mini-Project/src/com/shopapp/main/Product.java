package com.shopapp.main;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class Product {
	Scanner input = new Scanner(System.in);
	public void addProduct() throws ClassNotFoundException {
		Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
		try {
			Connection con=DriverManager.getConnection("jdbc:sqlserver://CM1VA492\\SQLEXPRESS;databaseName=ImpactMiniProject;user=sa;password=password_123");
			System.out.println("Connected");
			PreparedStatement pstmt = con.prepareStatement("insert into ProductDetails values (?,?,?,?)");
		    System.out.println("Enter the ID of Product to be added");
			int product_id=input.nextInt();
			System.out.println("Enter the Category of Product ");
			String product_category=input.next();
			System.out.println("Enter the Name of Product ");
			String product_name=input.next();
			System.out.println("Enter the Price of Product");
			float product_price=input.nextFloat();
			
			pstmt.setInt(1, product_id);
			pstmt.setString(2, product_category);
			pstmt.setString(3, product_name);
			pstmt.setFloat(4, product_price);
			
			pstmt.executeUpdate();
			System.out.println("Product is added");
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
	}
	public void updateProduct() throws ClassNotFoundException {
		Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
		try {
			Connection con=DriverManager.getConnection("jdbc:sqlserver://CM1VA492\\SQLEXPRESS;databaseName=ImpactMiniProject;user=sa;password=password_123");
			System.out.println("Connected");
			PreparedStatement pstmt = con.prepareStatement("update ProductDetails set product_name=? where product_id=? ");
			System.out.println("Enter the ID of Product to be updated");
			int product_id=input.nextInt();
			System.out.println("Enter the Name of Product ");
			String product_name=input.next();
			
			pstmt.setString(1, product_name);
			pstmt.setInt(2, product_id);
			pstmt.executeUpdate();
			System.out.println("Product updated");
			
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
	}
	public void deleteProduct() throws ClassNotFoundException{
		Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
		try {
			Connection con=DriverManager.getConnection("jdbc:sqlserver://CM1VA492\\SQLEXPRESS;databaseName=ImpactMiniProject;user=sa;password=password_123");
			System.out.println("Connected");
			PreparedStatement pstmt = con.prepareStatement("delete from ProductDetails where product_id=? ");
			System.out.println("Enter the ID of Product to be deleted");
			int product_id=input.nextInt();
			pstmt.setInt(1, product_id);
			pstmt.executeUpdate();
			System.out.println("Product Deleted Successfully");
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}

	}
	public void getProductById() throws ClassNotFoundException {
		Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
		try {
			Connection con=DriverManager.getConnection("jdbc:sqlserver://CM1VA492\\SQLEXPRESS;databaseName=ImpactMiniProject;user=sa;password=password_123");
			System.out.println("Connected");
			PreparedStatement pstmt = con.prepareStatement("select * from ProductDetails where product_id=? ");
			System.out.println("Enter the ID of Product");
			int product_id=input.nextInt();
			pstmt.setInt(1, product_id);
			
			ResultSet rs = pstmt.executeQuery();
			while(rs.next()) {
			System.out.println(rs.getInt("product_id")+"--"+rs.getString(2)+"--"+rs.getString(3)+"--"+rs.getFloat(4));
			}
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
		
	}
	public void getAllProduct() throws ClassNotFoundException {
		Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
		try {
			Connection con=DriverManager.getConnection("jdbc:sqlserver://CM1VA492\\SQLEXPRESS;databaseName=ImpactMiniProject;user=sa;password=password_123");
			System.out.println("This is the list of products");
			PreparedStatement pstmt = con.prepareStatement("select * from ProductDetails");
			
			ResultSet rs = pstmt.executeQuery();
			while(rs.next()) {
				System.out.println(rs.getInt(1)+"--"+rs.getString(2)+"--"+rs.getString(3)+"--"+rs.getFloat(4));
			}
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
		
	}
	
}
