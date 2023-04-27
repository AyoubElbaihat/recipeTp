package com.example.recipe.service;

import com.example.recipe.dao.jdbc.CategoryJdbcDao;
import com.example.recipe.dao.jdbc.RecipeJdbcDao;
import com.example.recipe.model.Category;
import com.example.recipe.model.Recipe;

import java.util.Date;
import java.util.List;

public class RecipeService {
    RecipeJdbcDao recipeJdbcDao = new RecipeJdbcDao();
    CategoryJdbcDao categoryJdbcDao = new CategoryJdbcDao();
    public List<Recipe> fetchAllRecipe() {
        return recipeJdbcDao.findAll();
    }
    public Recipe createRecipe(String recipeName, String description, String imageRecipe, String difficulty, int preparationTime,int idCategory) {
        Category selectedCategory = categoryJdbcDao.findById(idCategory);
        Recipe recipeToCreate = new Recipe(recipeName,description,imageRecipe,difficulty,preparationTime,selectedCategory);
        return recipeJdbcDao.create(recipeToCreate);
    }
}
