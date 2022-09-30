package com.shoppingapp.service;

import com.shoppingapp.mapper.OrderDetailsMapper;
import com.shoppingapp.model.OrderDetails;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.ArrayList;
import java.util.List;

public class OrderDetailsService {

    private JdbcTemplate jdbcTemplate;


    public JdbcTemplate getJdbcTemplate() {
        return jdbcTemplate;
    }

    public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public void submitOrder(OrderDetails orderDetails) {
        try {
            int rows = this.jdbcTemplate.update("insert into order_details_tbl values (?,?,?,?,?)", orderDetails.getUserId(), orderDetails.getCategoryId(), orderDetails.getProductId(), orderDetails.getQuantity(), orderDetails.getTotal());
            System.out.println("Order Created Successfully");
        } catch (EmptyResultDataAccessException e) {
            System.out.println("An error occurred while saving record");
        }
    }


    public List<OrderDetails> getAllOrders() {
        try {
            List<OrderDetails> orderDetailsList = this.jdbcTemplate.query("select * from order_details_tbl", new OrderDetailsMapper());
            return orderDetailsList;

        } catch (EmptyResultDataAccessException e) {
            System.out.println("Not able to fetch order details");
            return new ArrayList();

        }
    }
}

