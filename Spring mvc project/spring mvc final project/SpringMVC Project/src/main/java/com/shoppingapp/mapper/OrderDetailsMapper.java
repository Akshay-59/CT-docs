package com.shoppingapp.mapper;

import com.shoppingapp.model.OrderDetails;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class OrderDetailsMapper implements RowMapper<OrderDetails> {
    public OrderDetails mapRow(ResultSet rs, int rowNum) throws SQLException {
        OrderDetails orderDetails = new OrderDetails();
        orderDetails.setOrderId(rs.getInt(1));
        orderDetails.setUserId(rs.getInt(2));
        orderDetails.setCategoryId(rs.getInt(3));
        orderDetails.setProductId(rs.getInt(4));
        orderDetails.setQuantity(rs.getInt(5));
        orderDetails.setTotal(rs.getFloat(6));
        return orderDetails;
    }
}
