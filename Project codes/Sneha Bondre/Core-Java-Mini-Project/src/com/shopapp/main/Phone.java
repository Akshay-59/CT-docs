package com.shopapp.main;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class Phone {
	Scanner sc = new Scanner(System.in);
	public void getPhone() throws ClassNotFoundException {
		Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
		try {
			int bill=0;
			int quantity=0;
			Connection con=DriverManager.getConnection("jdbc:sqlserver://CM1VA492\\SQLEXPRESS;databaseName=ImpactMiniProject;user=sa;password=password_123");
			System.out.println("Connected");
			
			System.out.println("--------Phones------\r\n"
					+ "1. Iphone 11  55000\r\n"
					+ "2. Iphone 12 75000\r\n"
					+ "3. Samsung  50000\r\n"
					+ "4. Vivo 35000\r\n"
					+ "0. Exit\r\n"
					+ "---------------------");
			int choice = sc.nextInt();
			if(choice==1) {
				System.out.println("Enter quantity: ");
				quantity = sc.nextInt();
				bill=55000*quantity;
				String product_name = "Iphone 11";
				System.out.println("Name of Product: "+product_name+"\r\n"
						+ "Quantity: "+quantity+"\r\n"
						+ "Your Bill: "+bill+"\r\n"
						+ "Thank you for your purchase.");
				
				
					PreparedStatement pstmt = con.prepareStatement("insert into OrderDetails values (?,?,?)");
				    
					
					pstmt.setString(1, product_name);
					pstmt.setInt(2, quantity);
					pstmt.setFloat(3, bill);
					
					pstmt.executeUpdate();
					System.out.println("Order is added");
					System.out.println("Do you want to continue: ");
					System.out.println("1. Yes");
					System.out.println("2. No");
					int continueChoice = sc.nextInt();
					if(continueChoice==1) {
						Phone phone = new Phone();
						phone.getPhone();
					}
					else {
						CustomerModule customerModule = new CustomerModule();
					}
			}
			else if(choice==2) {
				System.out.println("Enter quantity: ");
				quantity = sc.nextInt();
				bill=75000*quantity;
				String product_name = "Iphone 12";
				System.out.println("Name of Product: "+product_name+"\r\n"
						+ "Quantity: "+quantity+"\r\n"
						+ "Your Bill: "+bill+"\r\n"
						+ "Thank you for your purchase.");
				
				
					PreparedStatement pstmt = con.prepareStatement("insert into OrderDetails values (?,?,?)");
				    
					
					pstmt.setString(1, product_name);
					pstmt.setInt(2, quantity);
					pstmt.setFloat(3, bill);
					
					pstmt.executeUpdate();
					System.out.println("Order is added");
					System.out.println("Do you want to continue: ");
					System.out.println("1. Yes");
					System.out.println("2. No");
					int continueChoice = sc.nextInt();
					if(continueChoice==1) {
						Phone phone = new Phone();
						phone.getPhone();
					}
					else {
						CustomerModule customerModule = new CustomerModule();
					}
			}
			else if(choice==3) {
				System.out.println("Enter quantity: ");
				quantity = sc.nextInt();
				bill=50000*quantity;
				String product_name = "Samsung";
				System.out.println("Name of Product: "+product_name+"\r\n"
						+ "Quantity: "+quantity+"\r\n"
						+ "Your Bill: "+bill+"\r\n"
						+ "Thank you for your purchase.");
				
				
					PreparedStatement pstmt = con.prepareStatement("insert into OrderDetails values (?,?,?)");
				    
					
					pstmt.setString(1, product_name);
					pstmt.setInt(2, quantity);
					pstmt.setFloat(3, bill);
					
					pstmt.executeUpdate();
					System.out.println("Order is added");
					System.out.println("Do you want to continue: ");
					System.out.println("1. Yes");
					System.out.println("2. No");
					int continueChoice = sc.nextInt();
					if(continueChoice==1) {
						Phone phone = new Phone();
						phone.getPhone();
					}
					else {
						CustomerModule customerModule = new CustomerModule();
					}
			}
			else if(choice==4) {
				System.out.println("Enter quantity: ");
				quantity = sc.nextInt();
				bill=35000*quantity;
				String product_name = "Vivo";
				System.out.println("Name of Product: "+product_name+"\r\n"
						+ "Quantity: "+quantity+"\r\n"
						+ "Your Bill: "+bill+"\r\n"
						+ "Thank you for your purchase.");
				
				
					PreparedStatement pstmt = con.prepareStatement("insert into OrderDetails values (?,?,?)");
				    
					
					pstmt.setString(1, product_name);
					pstmt.setInt(2, quantity);
					pstmt.setFloat(3, bill);
					
					pstmt.executeUpdate();
					System.out.println("Order is added");
					System.out.println("Do you want to continue: ");
					System.out.println("1. Yes");
					System.out.println("2. No");
					int continueChoice = sc.nextInt();
					if(continueChoice==1) {
						Phone phone = new Phone();
						phone.getPhone();
					}
					else {
						CustomerModule customerModule = new CustomerModule();
					}
			}
			else {
				CustomerModule customer = new CustomerModule();
			}
			
			
		}
		catch (SQLException e) {
			System.out.println(e.getMessage());
		}
	}
}
