package com.shopping.service.Impl;

import com.shopping.mapper.ProductMapper;
import com.shopping.model.Product;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import com.shopping.service.ProductService;

import java.util.ArrayList;
import java.util.List;

public class ProductServiceImpl implements ProductService {


    private JdbcTemplate jdbcTemplate;


    public JdbcTemplate getJdbcTemplate() {
        return jdbcTemplate;
    }

    public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }


    public Product getProductById(int id) {
        try {
            Product product = this.jdbcTemplate.queryForObject("select * from product_tbl where id=?", new ProductMapper(), id);
            return product;
        } catch (EmptyResultDataAccessException e) {
            System.out.println("No product with id "+id+" exists");
            return null;
        }
    }

    public List<Product> getAllProductsByCategory(int category) {
        try {
            List<Product> products = this.jdbcTemplate.query("select * from product_tbl where category_id= ?", new ProductMapper(), category);
            return products;
        } catch (EmptyResultDataAccessException e) {
            System.out.println("No product of category id "+category+" exists");
            return null;
        }
    }


    public List<Product> getAllProducts() {
        try {
            List<Product> products = this.jdbcTemplate.query("select * from product_tbl ", new ProductMapper());
            return products;
        } catch (EmptyResultDataAccessException e) {
            System.out.println("No products exists");
            return new ArrayList<>();
        }

    }

    public void saveProduct(Product product) {
        try {
            int row = this.jdbcTemplate.update("insert into product_tbl values (?,?,?)", product.getName(), product.getPrice(), product.getProductCategoryId());
            System.out.println("Product Created Successfully");
        } catch (EmptyResultDataAccessException e) {
            System.out.println("An error occurred while saving record");
        }
    }

    public void updateProduct(Product product) {
        Product dbProduct = getProductById(product.getId());
        if (dbProduct != null) {
            try {
                int row = this.jdbcTemplate.update("update product_tbl set name = ?, price = ?, category_id = ? where id = ?", product.getName(), product.getPrice(), product.getProductCategoryId(), product.getId());
                System.out.println("Product Updated Successfully");
            } catch (EmptyResultDataAccessException e) {
                System.out.println("An error occurred while updating record");
            }
        }
    }


    public void deleteProductById(int id) {
        Product product = getProductById(id);
        if (product != null) {
            try {
                int row = this.jdbcTemplate.update("delete from product_tbl where id = ?", id);
                System.out.println("Product Deleted Successfully");
            } catch (EmptyResultDataAccessException e) {
                System.out.println("An error occurred while deleting record");
            }
        }
    }
}
