package com.shoppingapp.service;

import com.shoppingapp.mapper.CategoryMapper;
import com.shoppingapp.model.Category;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.ArrayList;
import java.util.List;

public class CategoryService {
    private JdbcTemplate jdbcTemplate;


    public JdbcTemplate getJdbcTemplate() {
        return jdbcTemplate;
    }

    public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }


    public List<Category> getCategories() {
        try {
            List<Category> categories = this.jdbcTemplate.query("select * from category_tbl", new CategoryMapper());
            return categories;

        } catch (EmptyResultDataAccessException e) {
            System.out.println("Not able to fetch categories");
            return new ArrayList();

        }
    }

    public Category getCategoryById(int id) {
        try {
            Category category = this.jdbcTemplate.queryForObject("select * from category_tbl where id = ?", new CategoryMapper(), id);
            return category;

        } catch (EmptyResultDataAccessException e) {
            System.out.println("Unable to category with id " + id);
            return null;

        }
    }
}

