package com.example.recipe.dao.jdbc;

import com.example.recipe.dao.ConnectionManager;
import com.example.recipe.dao.crud.RecipeDao;
import com.example.recipe.model.Category;
import com.example.recipe.model.Recipe;
import org.apache.commons.lang3.StringUtils;

import java.sql.*;
import java.time.LocalDateTime;
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
            while (result.next()){
                Integer id = result.getInt("id");
                String recipeName = result.getString("recipeName");
                String description = result.getString("description");
                String imageRecipe = result.getString("imageRecipe");
                String difficulty = result.getString("difficulty");
                int preparationTime = result.getInt("preparationTime");
                LocalDateTime dateCreation = result.getTimestamp("dateCreation").toLocalDateTime();
                Category category = new Category(result.getInt("id"), result.getString("nameCategory"));
                recipeList.add(new Recipe(id, recipeName,description,imageRecipe,difficulty,preparationTime,dateCreation,category));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return recipeList;
    }

    @Override
    public Recipe findById(Integer integer) {

        Connection connection = ConnectionManager.getInstance();
        String query = "SELECT * FROM recipes r INNER JOIN categories c ON r.idCategory = c.id WHERE r.id = ?";
        try (PreparedStatement pst = connection.prepareStatement(query)) {
            pst.setInt(1, integer);
            ResultSet result = pst.executeQuery();
            if (result.next()) {
                return new Recipe(
                        result.getInt("id"),
                        result.getString("recipeName"),
                        result.getString("description"),
                        result.getString("imageRecipe"),
                        result.getString("difficulty"),
                        result.getInt("preparationTime"),
                        result.getTimestamp("dateCreation").toLocalDateTime(),
                        new Category(result.getInt("id"), result.getString("nameCategory"))
                );
            } else {
                return null;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public void update(Recipe entity) {

    }

    @Override
    public void delete(Recipe entity) {

    }

    public List<Recipe> findByCategoryName(String string) {
        Connection connection = ConnectionManager.getInstance();
        String query = "SELECT r.id, r.recipeName, r.description, r.imageRecipe, r.difficulty, r.preparationTime, r.dateCreation,c.id, c.nameCategory " +
                "FROM recipes r " +
                "INNER JOIN categories c ON r.idCategory = c.id WHERE c.nameCategory LIKE '"+string+"' ";
        List<Recipe> recipeList = new ArrayList<>();

        try (PreparedStatement pst = connection.prepareStatement(query)) {
//            pst.setString(1, string);
            ResultSet result = pst.executeQuery(query);
            while (result.next()){
                Integer id = result.getInt("id");
                String recipeName = result.getString("recipeName");
                String description = result.getString("description");
                String imageRecipe = result.getString("imageRecipe");
                String difficulty = result.getString("difficulty");
                int preparationTime = result.getInt("preparationTime");
                LocalDateTime dateCreation = result.getTimestamp("dateCreation").toLocalDateTime();
                Category category = new Category(result.getInt("id"), result.getString("nameCategory"));
                recipeList.add(new Recipe(id, recipeName,description,imageRecipe,difficulty,preparationTime,dateCreation,category));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return recipeList;
    }
    public List<Recipe> fetchLastSixDayRecipes() {
        LocalDateTime now = LocalDateTime.now();
        LocalDateTime sixDaysAgo = now.minusDays(6);
        List<Recipe> recipeList = new ArrayList<>();
        Connection connection = ConnectionManager.getInstance();
        String query = "SELECT r.id, r.recipeName, r.description, r.imageRecipe, r.difficulty, r.preparationTime, r.dateCreation,c.id, c.nameCategory " +
                "FROM recipes r " +
                "INNER JOIN categories c ON r.idCategory = c.id WHERE r.dateCreation >= ? AND r.dateCreation <= ?";

        try (PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setObject(1, sixDaysAgo);
            statement.setObject(2, now);
            ResultSet result = statement.executeQuery();
            while (result.next()){
                Integer id = result.getInt("id");
                String recipeName = result.getString("recipeName");
                String description = result.getString("description");
                String imageRecipe = result.getString("imageRecipe");
                String difficulty = result.getString("difficulty");
                int preparationTime = result.getInt("preparationTime");
                LocalDateTime dateCreation = result.getTimestamp("dateCreation").toLocalDateTime();
                Category category = new Category(result.getInt("id"), result.getString("nameCategory"));
                recipeList.add(new Recipe(id, recipeName,description,imageRecipe,difficulty,preparationTime,dateCreation,category));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return recipeList;
    }
    public List<Recipe> findByKeyword(String string) {
        Connection connection = ConnectionManager.getInstance();
        String query = "SELECT r.id, r.recipeName, r.description, r.imageRecipe, r.difficulty, r.preparationTime, r.dateCreation,c.id, c.nameCategory " +
                "FROM recipes r " +
                "INNER JOIN categories c ON r.idCategory = c.id WHERE r.description LIKE ? OR r.recipeName = ?;";
        List<Recipe> recipeList = new ArrayList<>();

        try (PreparedStatement pst = connection.prepareStatement(query)) {
            pst.setString(1, "%"+string+"%");
            pst.setString(2, "%"+string+"%");
            ResultSet result = pst.executeQuery();
            while (result.next()){
                Integer id = result.getInt("id");
                String recipeName = result.getString("recipeName");
                String description = result.getString("description");
                String imageRecipe = result.getString("imageRecipe");
                String difficulty = result.getString("difficulty");
                int preparationTime = result.getInt("preparationTime");
                LocalDateTime dateCreation = result.getTimestamp("dateCreation").toLocalDateTime();
                Category category = new Category(result.getInt("id"), result.getString("nameCategory"));
                recipeList.add(new Recipe(id, recipeName,description,imageRecipe,difficulty,preparationTime,dateCreation,category));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return recipeList;
    }

}
