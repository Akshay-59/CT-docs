package com.shopapp.main;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Main {
	
	public static void main(String[] args) throws ClassNotFoundException {
		//java.security.Security.setProperty("jdk.tls.disabledAlgorithms", "");
		Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
		try {
			Connection con=DriverManager.getConnection("jdbc:sqlserver://CM1VA492\\SQLEXPRESS;databaseName=ImpactMiniProject;user=sa;password=password_123");
			System.out.println("Connected");
			User user = new User();
			boolean isLogged = user.Login();
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
	}
}

