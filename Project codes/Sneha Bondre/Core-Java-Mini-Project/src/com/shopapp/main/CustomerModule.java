package com.shopapp.main;

import java.util.Scanner;

public class CustomerModule {
	Scanner sc = new Scanner(System.in);
	
	public CustomerModule() throws ClassNotFoundException {
		Phone phone = new Phone();
		Laptop laptop = new Laptop();
		
		System.out.println("------Select Category---------\r\n"
				+ "1. Laptops\r\n"
				+ "2. Phones\r\n"
				+ "3. Furniture\r\n"
				+ "4. Fashion\r\n"
				+ "5. Home Appliances\r\n"
				+ "0. Exit\r\n"
				+ "-----------------------------");
		int category = sc.nextInt();
		if(category==1) {
			laptop.getLaptop();
		}
		else if(category==2) {
			phone.getPhone();
		}
		else {
			User user = new User();
			boolean isLogged = user.Login();
		}
	}
}
