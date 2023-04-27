package com.example.recipe.dao.crud;

import com.example.recipe.dao.base.GenericDao;
import com.example.recipe.model.Recipe;

import java.util.List;


public interface RecipeDao extends GenericDao<Recipe, Integer> {
    List<Recipe> fetchLastSixDayRecipes();

    List<Recipe> findByCategoryName(String string);
    List<Recipe> findByKeyword(String string);
}
