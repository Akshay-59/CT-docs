package com.shopping.service;

import com.shopping.model.Category;

import java.util.List;

public interface CategoryService {
    public List<Category> getCategories();
    public Category getCategoryById(int id);

}
