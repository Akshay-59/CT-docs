package com.dal;

import java.sql.Connection;
import java.sql.DriverManager;

public class ConnectDatabase {

	 
	   public static Connection getConnection() {
		   Connection conn = null;
	      if (conn != null) return conn;
	      String database = "consoleappdbKY";
	      String userName = "MUMBAI1\\KrishnaY3";
	   //   userName.replace("/", "\\\\\\");
	//      System.out.println("Username:"+userName);
	      String password = "";
	    
	      return getConnection(database, userName, password);
	   }
	   private static Connection getConnection(String databaseName, String UserName, String password) {
		   Connection conn = null;
	      try {
	    	  String serverName = "CM1VA549\\SQLEXPRESS";
	    	  String userName = "MUMBAI1\\KrishnaY3";
	    	  String database = "shoppingapp";
	    //	  userName.replace("/", "\\");
		      String pasword = "";
		      String url1 = "jdbc:sqlserver://" +serverName + ":1433;DatabaseName=" + database + ";encrypt=true;trustServerCertificate=true;integratedSecurity=true;";
	    	  String url = "jdbc:sqlserver://localhost;databasename=consoleappdbKY;integratedSecurity=true";
	         Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
	      //   conn = DriverManager.getConnection("jdbc:sqlserver://localhost/" + databaseName + "?user=" + UserName + "&password=" + password);
	      //   conn = DriverManager.getConnection("jdbc:sqlserver://localhost;user=MUMBAI1/KrishnaY3;password=;integratedSecurity=true");
	         conn = DriverManager.getConnection(url1,userName,"");
	      } catch (Exception e) {
	         e.printStackTrace();
	      }
	      return conn;
	   }
}
