package com.shopping;

import java.util.Scanner;

public class Customer {

	public boolean Login(){
		Scanner sc = new Scanner(System.in);
		boolean success=false;
		System.out.println("----------MENU----------");
   		System.out.println("1.Admin");
   		System.out.println("2.Customer");
   		System.out.println("0.Exit");
   		System.out.println("Enter Your Role or 0 to Exit");
   		int option = sc.nextInt();
   		if(option==2) {
   			success = isValidUser();
   			
   		}
   		else if(option==1) {
   			System.out.println("Admin");
   		}
   		else{
   			System.out.println("Exited");

   		}
   		return success;
	}
	
	public static boolean isValidUser() {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter Your Username:");
		String uname = sc.next();
	 
		System.out.println("Enter Your Password:");
		String password = sc.next();
		boolean isValid=false;
		
		if (uname.equals("cust") && password.equals("cust")) {
				System.out.println("You are Authenticated");
				isValid=true;
			
		}
		else {
			 isValid=false;
		}
		
		return isValid;
	}
}
