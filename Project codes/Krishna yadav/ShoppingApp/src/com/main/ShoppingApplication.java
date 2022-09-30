package com.main;

import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.model.Admin;
import com.model.Customer;
import com.model.Product;
import com.service.impl.CommonServiceImpl;

public class ShoppingApplication {

	public static void main(String[] args) throws UnsupportedEncodingException {

		Scanner scanner = new Scanner(System.in);
		System.out.println("You Are?:"+"\n");

		System.out.println("1) Admin"+"\n"+"2) Customer"+"\n"+"0) Exit");
		ArrayList<Integer>menuList = new ArrayList<Integer>();
		menuList.add(1);
		menuList.add(2);
		menuList.add(0);
		
		int selectedOption = scanner.nextInt();
		
		if(!menuList.contains(Integer.valueOf(selectedOption))) {
			System.err.println("Invalid menu selected");
		}else {
			
		
		
		CommonServiceImpl serviceImpl = new CommonServiceImpl();
		
	switch(selectedOption){
		
		case 1:
			System.out.println("<---------- Login as admin ----------->");
			System.out.println("Enter username: ");
			String adminUsername = scanner.next();
			System.out.println("Enter Password: ");
			String adminPassword = scanner.next();
		
		boolean isValid = serviceImpl.validateAdminLogin(adminUsername, adminPassword);
		
		if(isValid) {
			System.out.println("<---------- Admin Menu ----------->");
			
			System.out.println("1) Add Product"+"\n"+"2) Update Product"+"\n"+"3) Delete Product"
					+"\n"+"4) Get Product by ID"+"\n"+"5) Get All Products"+"\n"+"6) Add customer"
					+"\n"+"7) Update Customer Information"+"\n"+"8) Delete Customer"+"\n"+"9) Get Customer by ID"
					+"\n"+"10) Get All Customer"+"\n"+"0) Exit");
			
			
			int adminMenuSelected = scanner.nextInt();
			System.out.println("===================================");
			
			switch(adminMenuSelected) {
			
			case 1:
				
				System.out.println("Enter Product category: ");
				String category = scanner.nextLine();
				scanner.nextLine();
				System.out.println("Enter Product name: ");
				String productName = scanner.nextLine();
				System.out.println("Enter Quantity: ");
				int quantity = scanner.nextInt();
				System.out.println("Enter Price: ");
				double price = scanner.nextDouble();
				
				Product product  = new Product();
				product.setProductCategory(category);
				product.setProductName(productName);
				product.setQuantity(quantity);
				product.setPrice(price);
				
				serviceImpl.addProduct(product);
			break;
			case 2:
				System.out.println("Enter Product ID: ");
				int productId = scanner.nextInt();
				System.out.println("Enter Product category: ");
				String category1 = scanner.next();
				scanner.nextLine();
				System.out.println("Enter Product name: ");
				String productName1 = scanner.nextLine();
				System.out.println("Enter Quantitye: ");
				int quantity1 = scanner.nextInt();
				System.out.println("Enter Price: ");
				double price1 = scanner.nextDouble();
				
				Product product1  = new Product();
				product1.setId(productId);
				product1.setProductCategory(category1);
				product1.setProductName(productName1);
				product1.setQuantity(quantity1);
				product1.setPrice(price1);
				
				serviceImpl.updateProduct(product1);
				
				
			break;
			case 3:
				
				System.out.println("Enter Product ID: ");
				int prodId = scanner.nextInt();
				Product p= new Product(); 
				p.setId(prodId);
				serviceImpl.deleteProduct(p);
				
			break;
			case 4:
				
				System.out.println("Enter Product ID: ");
				int pId = scanner.nextInt();
				Product p1= new Product(); 
				p1.setId(pId);
				serviceImpl.getProductById(p1);
				
				
			break;
			case 5:
				serviceImpl.getAllProducts();
				
			break;
			case 6:
				System.out.println("Enter Customer username ");
				String custName = scanner.nextLine();
				System.out.println("Enter Password ");
				String custPass = scanner.next();
				
				Customer cust = new Customer();
				cust.setUsername(custName);
				cust.setPassword(custPass);
				serviceImpl.addCustomer(cust);
			break;
			case 7:
				
				System.out.println("Enter Customer ID ");
				int custId = scanner.nextInt();
				scanner.nextLine();
				System.out.println("Enter Customer username ");
				String custName1 = scanner.nextLine();
				System.out.println("Enter Password ");
				String custPass1 = scanner.nextLine();
				
				Customer cust1 = new Customer();
				cust1.setId(custId);
				cust1.setUsername(custName1);
				cust1.setPassword(custPass1);
				serviceImpl.updateCustomer(cust1);
				
			break;
			case 8:
				
				System.out.println("Enter Customer ID ");
				int custId1 = scanner.nextInt();
				
				serviceImpl.deleteCustomer(custId1);
				
			break;
			case 9:
				
				System.out.println("Enter Customer ID ");
				int cusId = scanner.nextInt();
				
				serviceImpl.getCustomerById(cusId);
				
			break;
			case 10:
				
				serviceImpl.getAllCustomers();
			break;
			case 0:
				System.out.println("Thank you, good bye!");
				System.exit(0);
			break;
			
			}
			
		}
		else{System.err.println("Wrong username or password!");};
			
			break;
		case 2:
			
			System.out.println("<---------- Login as Customer ----------->");
			System.out.println("Enter username: ");
			String custUsername = scanner.next();
			System.out.println("Enter Password: ");
			String custPassword = scanner.next();
		
		boolean isCustValid = serviceImpl.validateCustomerLogin(custUsername, custPassword);
			
		if(isCustValid) {
			
			System.out.println("<---------- Select Category ----------->");

			List<String> categories = serviceImpl.getAllCategories();
			int count=0;
			for(String category: categories) {
				System.out.println(++count +") "+category);
			}
			
			int categorySelected = scanner.nextInt();
			
			if(categorySelected > count) {
				System.err.println("Invalid category selected");
			}else {
				
				String selectcedCategory = categories.get(categorySelected-1);
				
				List<Product> prodList = serviceImpl.getAllProductBasedOnCategory(selectcedCategory);
				List<Integer> productIdList = new ArrayList<Integer>();
				
				System.out.println("<---------- Select Product ----------->");
				for(Product pr:prodList) {
					System.out.println(pr.getId()+". "+pr.getProductName()+" "+""+pr.getPrice()+"/-"+" [ Avalb Qnty: "+pr.getQuantity()+"]");
					productIdList.add(pr.getId());
				}
				
				int selectedProduct = scanner.nextInt();
				
				if(!productIdList.contains(Integer.valueOf(selectedProduct))) {
					System.err.println("Invalid product selected");
				}else {
					
					System.out.println("<---------- Your Product ----------->");
					Product p = new Product();
					p.setId(selectedProduct);
					
					Product billingProd =  serviceImpl.getProductById(p);
					
					System.out.println();
					System.out.println("<---------- Enter Quantity ----------->");
					int reqQuantity = scanner.nextInt();
					
					if(reqQuantity > billingProd.getQuantity()) {
						System.err.println("Sorry, required quantity not available. Availabe quantiy is "+billingProd.getQuantity());
					}else {
						
						System.out.println();
						System.out.println("<---------- INVOICE ----------->");
						System.out.println("Name = "+billingProd.getProductName());
						System.out.println("Quantity =  "+reqQuantity);
						System.out.println("Your Bill =  "+reqQuantity * billingProd.getPrice());
						System.out.println("Thank you for your purchase!");
					}
				}
				
			}
			
		}else {
			System.err.println("Wrong username or password!");
		}
			
			break;
		case 0:
			
			System.out.println("Thank you, good bye!");
			System.exit(0);
			
			break;
			
		} //Switch end
	}// Else end
		
	}

}
