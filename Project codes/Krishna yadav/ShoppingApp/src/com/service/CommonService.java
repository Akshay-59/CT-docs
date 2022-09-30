package com.service;

import java.util.List;

import com.model.Admin;
import com.model.Customer;
import com.model.Product;

public interface CommonService {

	/* Admin */
	public void addAdmin(Admin admin);
	public boolean validateAdminLogin(String username, String pass);
	
	/* Customer */
	public void addCustomer(Customer customer);
	public boolean validateCustomerLogin(String username, String pass);
	public void updateCustomer(Customer cust);
	public void deleteCustomer(int cust);
	public Customer getCustomerById(int id);
	public List<Customer> getAllCustomers();
	
	/* Product */
	public void addProduct(Product product);
	public void updateProduct(Product product);
	public void deleteProduct(Product product);
	public Product getProductById(Product product);
	public List<Product> getAllProducts();
	public List<String> getAllCategories();
	public List<Product> getAllProductBasedOnCategory(String category);
	
	
	
	
}
