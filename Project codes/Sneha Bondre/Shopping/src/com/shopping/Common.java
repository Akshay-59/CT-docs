package com.shopping;

import java.util.Scanner;

public class Common {
	
	public Common() {
		Scanner sc = new Scanner(System.in);
		 Product product = new Product();
		System.out.println("--------Category---------\r\n"
		 		+ "1. Phone\r\n"
		 		+ "2. Laptop\r\n"
		 		+ "3. Furniture\r\n"
		 		+ "0. Exit"
		 		+ "-------------------------");
		 
		 System.out.println("Select Category");
		 int choice = sc.nextInt();
		 if(choice==1) {
			 product.getMobile();
		 }
		 else if(choice==2) {
			 product.getLaptop();
		 }
		 else if(choice==3) {
			 product.getFurniture();
		 }
		 else {
			 Customer customer = new Customer();
				boolean isLogged = customer.Login();
				if(isLogged) {
					Common common = new Common();

					}
		 }
	}

}
