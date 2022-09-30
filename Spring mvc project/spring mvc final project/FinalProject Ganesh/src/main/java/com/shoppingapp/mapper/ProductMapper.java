package com.shoppingapp.mapper;

import com.shoppingapp.model.Product;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class ProductMapper implements RowMapper<Product> {

    public Product mapRow(ResultSet rs, int rowNum) throws SQLException {
        Product product = new Product();
        product.setId(rs.getInt(1));
        product.setName(rs.getString(2));
        product.setPrice(rs.getFloat(3));
        product.setProductCategoryId(rs.getInt(4));
        return product;
    }
}