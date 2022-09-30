package com.model;

public class Product {

	private int id;
	private String productCategory;
	private String productName;
	private int quantity;
	private double price;
	public Product() {
		super();
	}
	public Product(int id, String productCategory, String productName, int quantity, double price) {
		super();
		this.id = id;
		this.productCategory = productCategory;
		this.productName = productName;
		this.quantity = quantity;
		this.price = price;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getProductCategory() {
		return productCategory;
	}
	public void setProductCategory(String productCategory) {
		this.productCategory = productCategory;
	}
	public String getProductName() {
		return productName;
	}
	public void setProductName(String productName) {
		this.productName = productName;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	@Override
	public String toString() {
		return "Product [id=" + id + ", productCategory=" + productCategory + ", productName=" + productName
				+ ", quantity=" + quantity + ", price=" + price + "]";
	}
	
	
	
}

