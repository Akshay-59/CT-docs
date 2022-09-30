package com.shopping.service;

import org.springframework.jdbc.core.JdbcTemplate;

public interface JdbcConnection {
    public JdbcTemplate getJdbcTemplate();
    public void setJdbcTemplate(JdbcTemplate jdbcTemplate);

}
