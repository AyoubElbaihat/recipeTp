package com.example.recipe.service;

import com.example.recipe.dao.crud.CategoryDao;
import com.example.recipe.dao.crud.RecipeDao;
import com.example.recipe.dao.jdbc.CategoryJdbcDao;
import com.example.recipe.dao.jdbc.RecipeJdbcDao;
import com.example.recipe.model.Category;
import com.example.recipe.model.Recipe;

import java.util.Date;
import java.util.List;
import java.util.Random;

public class RecipeService {

    private static RecipeDao recipeDao = new RecipeJdbcDao();
    private static CategoryDao categoryDao = new CategoryJdbcDao();

    public List<Recipe> fetchAllRecipe() {
        return recipeDao.findAll();
    }
    public Recipe fetchById(int integer){
        return recipeDao.findById(integer);
    }
    public List<Recipe> fetchByCategoryName(String string){
        return recipeDao.findByCategoryName(string);
    }
    public List<Recipe> fetchByKeyword(String string){
        return recipeDao.findByKeyword(string);
    }
    public Recipe createRecipe(String recipeName, String description, String imageRecipe, String difficulty, int preparationTime,int idCategory) {
        Category selectedCategory = categoryDao.findById(idCategory);
        Recipe recipeToCreate = new Recipe(recipeName,description,imageRecipe,difficulty,preparationTime,selectedCategory);
        return recipeDao.create(recipeToCreate);
    }
    public List<Recipe> fetchLastSixDayRecipes(){
        return recipeDao.fetchLastSixDayRecipes();
    }
    public Recipe fetchRandomLastSixDayRecipes(){
        List<Recipe> recipeList =recipeDao.fetchLastSixDayRecipes();
        int listsize = recipeList.size();
        Random random = new Random();
        Recipe randomRecipe = recipeList.get(random.nextInt(listsize));
        return randomRecipe;
    }


}
