package com.example.recipe.dao.jdbc;

import com.example.recipe.dao.ConnectionManager;
import com.example.recipe.dao.crud.CategoryDao;
import com.example.recipe.model.Category;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class CategoryJdbcDao implements CategoryDao {
    @Override
    public Category create(Category entity) {
        return null;
    }

    @Override
    public List<Category> findAll() {
        Connection connection = ConnectionManager.getInstance();
        String query = "SELECT id, nameCategory FROM categories";
        List<Category> categoryList = new ArrayList<>();

        try (Statement pst = connection.createStatement()) {
            ResultSet result = pst.executeQuery(query);

            while (result.next()) {
                Category category = new Category(
                        result.getInt("id"),
                        result.getString("nameCategory")
                );
                categoryList.add(category);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return categoryList;
    }

    @Override
    public Category findById(Integer integer) {
        Connection connection = ConnectionManager.getInstance();
        String query = "SELECT id, nameCategory  FROM categories WHERE id = ?";
        try (PreparedStatement pst = connection.prepareStatement(query)) {
            pst.setInt(1, integer);
            ResultSet result = pst.executeQuery();
            if (result.next()) {
                return new Category(
                        result.getInt("id"),
                        result.getString("nameCategory")
                );
            } else {
                return null;
            }
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }
    public Category findByName(String string) {
        Connection connection = ConnectionManager.getInstance();
        String query = "SELECT id, nameCategory  FROM categories WHERE nameCategory = ?";
        try (PreparedStatement pst = connection.prepareStatement(query)) {
            pst.setString(1, string);
            ResultSet result = pst.executeQuery();
            if (result.next()) {
                return new Category(
                        result.getInt("id"),
                        result.getString("nameCategory")
                );
            } else {
                return null;
            }
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public void update(Category entity) {

    }

    @Override
    public void delete(Category entity) {

    }
}
