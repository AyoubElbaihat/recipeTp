package com.example.recipe.service;

import com.example.recipe.dao.jdbc.CategoryJdbcDao;
import com.example.recipe.model.Category;

import java.util.List;

public class CategoryService {
    CategoryJdbcDao categoryJdbcDao = new CategoryJdbcDao();
    public List<Category> fetchAllCategory() {
        return categoryJdbcDao.findAll();
    }
}
