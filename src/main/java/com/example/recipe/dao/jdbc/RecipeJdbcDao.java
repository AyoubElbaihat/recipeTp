package com.example.recipe.dao.jdbc;

import com.example.recipe.dao.ConnectionManager;
import com.example.recipe.dao.crud.RecipeDao;
import com.example.recipe.model.Category;
import com.example.recipe.model.Recipe;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class RecipeJdbcDao implements RecipeDao {
    @Override
    public Recipe create(Recipe entity) {
        Connection connection = ConnectionManager.getInstance();
        String query = "INSERT INTO recipes (recipeName, description, imageRecipe, difficulty, preparationTime, dateCreation, idCategory) VALUES (?, ?, ?, ?, ?, ?, ?)";
        try (PreparedStatement pst = connection.prepareStatement(query, Statement.RETURN_GENERATED_KEYS)) {
            pst.setString(1, entity.getRecipeName());
            pst.setString(2, entity.getDescription());
            pst.setString(3, entity.getImageRecipe());
            pst.setString(4, entity.getDifficulty());
            pst.setInt(5, entity.getPreparationTime());
            pst.setTimestamp(6, Timestamp.valueOf(entity.getDateCreation()));
            pst.setInt(7, entity.getCategory().getId());
            int result = pst.executeUpdate();
            if (result == 1) {
                ResultSet generatedKeys = pst.getGeneratedKeys();
                if (generatedKeys.next()) {
                    Integer id = generatedKeys.getInt(1);
                    entity.setId(id);
                    return entity;
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }


    @Override
    public List<Recipe> findAll() {
        Connection connection = ConnectionManager.getInstance();
        String query = "SELECT r.id, r.recipeName, r.description, r.imageRecipe, r.difficulty, r.preparationTime, r.dateCreation,c.id, c.nameCategory " +
                "FROM recipes r " +
                "INNER JOIN categories c ON r.idCategory = c.id";
        List<Recipe> recipeList = new ArrayList<>();

        try (Statement pst = connection.createStatement()) {
            ResultSet result = pst.executeQuery(query);

            while (result.next()) {
                Recipe r = new Recipe(
                        result.getInt("id"),
                        result.getString("recipeName"),
                        result.getString("description"),
                        result.getString("imageRecipe"),
                        result.getString("difficulty"),
                        result.getInt("preparationTime"),
                        result.getTimestamp("dateCreation").toLocalDateTime(),
                        new Category(result.getInt("idCategory"), result.getString("nameCategory"))
                );
                recipeList.add(r);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return recipeList;
    }

    @Override
    public Recipe findById(Integer integer) {
        return null;
    }

    @Override
    public void update(Recipe entity) {

    }

    @Override
    public void delete(Recipe entity) {

    }
}
