package com.service.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.dal.ConnectDatabase;
import com.model.Admin;
import com.model.Customer;
import com.model.Product;
import com.service.CommonService;

public class CommonServiceImpl implements CommonService {

	@Override
	public boolean validateAdminLogin(String username, String pass) {
		boolean isValid = false; 
		Connection con = ConnectDatabase.getConnection();
		 try{
			 
			  if (con != null) {
			         
				  Statement stmt = con.createStatement();
					ResultSet rs = stmt.executeQuery("select * from admin where username='"+username+"' and password='"+pass+"'");
			         
			       if(rs.next()) {
			    	   isValid = true;
			       }
			         
			         con.close();
			      }
			 
		 }catch(Exception e) {
			 e.printStackTrace();
		 }
		return isValid;
	}

	@Override
	public boolean validateCustomerLogin(String username, String pass) {
		
		boolean isValid = false; 
		Connection con = ConnectDatabase.getConnection();
		 try{
			 
			  if (con != null) {
			         
				  Statement stmt = con.createStatement();
					ResultSet rs = stmt.executeQuery("select * from customers where username='"+username+"' and password='"+pass+"' ");
			         
			       if(rs.next()) {
			    	   isValid = true;
			       }
			         
			         con.close();
			      }
			 
		 }catch(Exception e) {
			 e.printStackTrace();
		 }
		return isValid;
	}

	@Override
	public void addProduct(Product product) {
		Connection con = ConnectDatabase.getConnection();
		 try{
			 
			  if (con != null) {
			         
			         PreparedStatement stmt = con.prepareStatement("Insert into products values(?,?,?,?)");
			         stmt.setString(1, product.getProductCategory());
			         stmt.setString(2, product.getProductName());
			         stmt.setInt(3, product.getQuantity());
			         stmt.setDouble(4, product.getPrice());
			        
			         
			         int result = stmt.executeUpdate();
			         if(result>0) {
			        	 System.out.println("Product added!!");
			         }else {
			        	 System.err.println("Failed to add Product.");
			         }
			         
			         con.close();
			      }
			 
		 }catch(Exception e) {
			 e.printStackTrace();
		 }
	}

	@Override
	public void addAdmin(Admin admin) {
		
		 Connection con = ConnectDatabase.getConnection();
		 try{
			 
			  if (con != null) {
			         
			         PreparedStatement stmt = con.prepareStatement("Insert into admin values(?,?)");
			         stmt.setString(1, admin.getUsername());
			         stmt.setString(2, admin.getPassword());
			         
			         int result = stmt.executeUpdate();
			         if(result>0) {
			        	 System.out.println("Admin added!!");
			         }else {
			        	 System.err.println("Failed to add admin.");
			         }
			         
			         con.close();
			      }
			 
		 }catch(Exception e) {
			 e.printStackTrace();
		 }
		
	}

	@Override
	public void addCustomer(Customer cust) {
		
		 Connection con = ConnectDatabase.getConnection();
		 try{
			 
			  if (con != null) {
			         
			         PreparedStatement stmt = con.prepareStatement("Insert into customers values(?,?)");
			         stmt.setString(1, cust.getUsername());
			         stmt.setString(2, cust.getPassword());
			         
			         int result = stmt.executeUpdate();
			         if(result>0) {
			        	 System.out.println("Customer added!!");
			         }else {
			        	 System.err.println("Failed to add customer.");
			         }
			         
			         con.close();
			      }
			 
		 }catch(Exception e) {
			 e.printStackTrace();
		 }
		
	}



	@Override
	public void deleteCustomer(int custId) {
		 Connection con = ConnectDatabase.getConnection();
		 try{
			 
			  if (con != null) {
			         
			         PreparedStatement stmt = con.prepareStatement("delete from  customers where id=?");
			         stmt.setInt(1, custId);
			         
			         int result = stmt.executeUpdate();
			         if(result>0) {
			        	 System.out.println("Customer Deleted!!");
			         }else {
			        	 System.err.println("Failed to Delete customer.");
			         }
			         
			         con.close();
			      }
			 
		 }catch(Exception e) {
			 e.printStackTrace();
		 }
		
	}

	@Override
	public Customer getCustomerById(int id) {
		 Connection con = ConnectDatabase.getConnection();
		 Customer cust = new Customer();
		 try{
			 
			  if (con != null) {
			         
				  Statement stmt = con.createStatement();
					ResultSet rs = stmt.executeQuery("select * from customers where id="+id);
					
					while (rs.next()) {
						cust.setId(rs.getInt(1));
						cust.setUsername(rs.getString(2));
						cust.setPassword(rs.getString(3));
					}
					
					System.out.println("[ Id: "+cust.getId()+", Username: "+cust.getUsername()+", Password: "+cust.getPassword()+"]");
			         
			         con.close();
			      }
			  
			 
		 }catch(Exception e) {
			 e.printStackTrace();
		 }
		return cust;
		
	}

	@Override
	public List<Customer> getAllCustomers() {
		
		 Connection con = ConnectDatabase.getConnection();
		 
		List< Customer> custList = new ArrayList<Customer>();
		 try{
			 
			  if (con != null) {
			         
				  Statement stmt = con.createStatement();
					ResultSet rs = stmt.executeQuery("select * from customers");
					
					while (rs.next()) {
						Customer cust = new Customer();
						cust.setId(rs.getInt(1));
						cust.setUsername(rs.getString(2));
						cust.setPassword(rs.getString(3));
						custList.add(cust);
					}
					
					
			         
			         con.close();
			         
			         for(Customer cu:custList) {
			        	 System.out.println("[ Id: "+cu.getId()+", Username: "+cu.getUsername()+", Password: "+cu.getPassword()+"]");
			         }
			      }
			  
			 
		 }catch(Exception e) {
			 e.printStackTrace();
		 }
		return custList;
		
	}

	@Override
	public void updateProduct(Product product) {
		
		 Connection con = ConnectDatabase.getConnection();
		 try{
			 
			  if (con != null) {
			         
			         PreparedStatement stmt = con.prepareStatement("update products set category=?, name=?, quantity=?,price=? where id=?");
			         stmt.setString(1, product.getProductCategory());
			         stmt.setString(2, product.getProductName());
			         stmt.setInt(3, product.getQuantity());
			         stmt.setDouble(4, product.getPrice());
			         stmt.setDouble(5, product.getId());
			         
			         int result = stmt.executeUpdate();
			         if(result>0) {
			        	 System.out.println("Product updated!!");
			         }else {
			        	 System.err.println("Failed to update product.");
			         }
			         
			         con.close();
			      }
			 
		 }catch(Exception e) {
			 e.printStackTrace();
		 }
	}

	@Override
	public void deleteProduct(Product product) {
		 Connection con = ConnectDatabase.getConnection();
		 try{
			 
			  if (con != null) {
			         
			         PreparedStatement stmt = con.prepareStatement("delete from  products where id=?");
			         stmt.setInt(1, product.getId());
			         
			         int result = stmt.executeUpdate();
			         if(result>0) {
			        	 System.out.println("Product Deleted!!");
			         }else {
			        	 System.err.println("Failed to Delete product.");
			         }
			         
			         con.close();
			      }
			 
		 }catch(Exception e) {
			 e.printStackTrace();
		 }
		
	}

	@Override
	public Product getProductById(Product product) {
		 Connection con = ConnectDatabase.getConnection();
		 Product produ = new Product();
		 try{
			 
			  if (con != null) {
			         
				  Statement stmt = con.createStatement();
					ResultSet rs = stmt.executeQuery("select * from products where id="+product.getId());
					
					while (rs.next()) {
						produ.setId(rs.getInt(1));
						produ.setProductCategory(rs.getString(2));
						produ.setProductName(rs.getString(3));
						produ.setQuantity(rs.getInt(4));
						produ.setPrice(rs.getDouble(5));
					}
					
					System.out.println("Id: "+produ.getId()+" | Category: "+produ.getProductCategory()
					+" | Name: "+produ.getProductName()+" | Quantiy: "+produ.getQuantity()+" | Price: "+produ.getPrice());
			         
			         con.close();
			      }
			  
			 
		 }catch(Exception e) {
			 e.printStackTrace();
		 }
		return produ;
		
	}

	@Override
	public List<Product> getAllProducts() {
		 Connection con = ConnectDatabase.getConnection();
		 
			List< Product> prodList = new ArrayList<Product>();
			 try{
				 
				  if (con != null) {
				         
					  Statement stmt = con.createStatement();
						ResultSet rs = stmt.executeQuery("select * from products");
						
						while (rs.next()) {
							Product p = new Product();
							p.setId(rs.getInt(1));
							p.setProductCategory(rs.getString(2));
							p.setProductName(rs.getString(3));
							p.setQuantity(rs.getInt(4));
							p.setPrice(rs.getDouble(5));
							prodList.add(p);
						}
						
						for(Product prd:prodList) {
							
							System.out.println("["+"Id: "+prd.getId()+", Category: "+prd.getProductCategory()
							+", Name: "+prd.getProductName()+",Quantity: "+prd.getQuantity()+",Price: "+prd.getPrice()+"]");
						}
				         
				         con.close();
				      }
				  
				 
			 }catch(Exception e) {
				 e.printStackTrace();
			 }
			return prodList;
		
	}

	@Override
	public void updateCustomer(Customer cust) {
			
			 Connection con = ConnectDatabase.getConnection();
			 try{
				 
				  if (con != null) {
				         
				         PreparedStatement stmt = con.prepareStatement("update customers set username=?, password=? where id=?");
				         stmt.setString(1, cust.getUsername());
				         stmt.setString(2, cust.getPassword());
				         stmt.setInt(3, cust.getId());
				         
				         int result = stmt.executeUpdate();
				         if(result>0) {
				        	 System.out.println("Customer updated!!");
				         }else {
				        	 System.err.println("Failed to update customer.");
				         }
				         
				         con.close();
				      }
				 
			 }catch(Exception e) {
				 e.printStackTrace();
			 }
			
		
	}

	@Override
	public List<String> getAllCategories() {
		Connection con = ConnectDatabase.getConnection();
		List<String> catList = new ArrayList<String>();
		 try{
			 
			  if (con != null) {
			         
				  Statement stmt = con.createStatement();
					ResultSet rs = stmt.executeQuery("select  category from products");
			         
					while(rs.next()) {
						catList.add(rs.getString(1));
					}
			         
			         con.close();
			      }
			 
		 }catch(Exception e) {
			 e.printStackTrace();
		 }
		return catList;
	}

	@Override
	public List<Product> getAllProductBasedOnCategory(String category) {
		Connection con = ConnectDatabase.getConnection();
		
		List<Product> pList = new ArrayList<Product>();
		 try{
			 
			  if (con != null) {
			         
				  Statement stmt = con.createStatement();
					ResultSet rs = stmt.executeQuery("select * from products where category='"+category+"' ");
			         
			     while(rs.next()) {
			    	 Product product = new Product();
			    	 product.setId(rs.getInt(1));
			    	 product.setProductCategory(rs.getString(2));
			    	 product.setProductName(rs.getString(3));
			    	 product.setQuantity(rs.getInt(4));
			    	 product.setPrice(rs.getDouble(5));
			    	 pList.add(product);
			    	 
			     }
			         
			         con.close();
			      }
			 
		 }catch(Exception e) {
			 e.printStackTrace();
		 }
		return pList;
	}


}
