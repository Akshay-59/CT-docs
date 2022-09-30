package com.shopapp.main;

import java.util.Scanner;

public class AdminModule {
	Scanner sc = new Scanner(System.in);
	public AdminModule() throws ClassNotFoundException {
		Product product = new Product();
		Customer customer = new Customer();
		System.out.println("--------Admin Menu----------\r\n"
				+ "1. Add Product\r\n"
				+ "2. Update Product\r\n"
				+ "3. Delete Product\r\n"
				+ "4. Get Product by ID\r\n"
				+ "5. Get All Products\r\n"
				+ "6. Add customer\r\n"
				+ "7. Update Customer Information\r\n"
				+ "8. Delete Customer\r\n"
				+ "9. Get Customer by ID\r\n"
				+ "10. Get All Customer\r\n"
				+ "0. Exit\r\n"
				+ "--------------------------------------");
		int option = sc.nextInt();
		if(option==1) {
			product.addProduct();
		}
		else if(option==2) {
			product.updateProduct();
		}
		else if(option==3) {
			product.deleteProduct();
		}
		else if(option==4) {
			product.getProductById();
		}
		else if(option==5) {
			product.getAllProduct();
		}
		else if(option==6) {
			customer.addCustomer();
		}
		else if(option==7) {
			customer.updateCustomer();
		}
		else if(option==8) {
			customer.deleteCustomer();
		}
		else if(option==9) {
			customer.getCustomerById();
		}
		else if(option==10) {
			customer.getAllCustomer();
		}
		else {
			User user = new User();
			boolean isLogged = user.Login();
		}
	}

}
