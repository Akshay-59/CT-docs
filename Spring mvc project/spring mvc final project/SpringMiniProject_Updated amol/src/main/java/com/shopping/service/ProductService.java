package com.shopping.service;

import com.shopping.model.Product;

import java.util.List;

public interface ProductService {
    public Product getProductById(int id);
    public List<Product> getAllProductsByCategory(int category);
    public List<Product> getAllProducts();
    public void saveProduct(Product product);
    public void updateProduct(Product product);

    public void deleteProductById(int id);

}
