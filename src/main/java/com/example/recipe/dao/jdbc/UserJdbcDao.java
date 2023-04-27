package com.example.recipe.dao.jdbc;

import com.example.recipe.dao.ConnectionManager;
import com.example.recipe.dao.crud.UserDao;
import com.example.recipe.model.User;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class UserJdbcDao implements UserDao {

    @Override
    public User create(User entity) {
        Connection connection = ConnectionManager.getInstance();
        String query = "INSERT INTO users (email, password, firstName, lastName, image) VALUES (?, ?, ?, ?, ?)";
        try (PreparedStatement pst = connection.prepareStatement(query, Statement.RETURN_GENERATED_KEYS)) {
            pst.setString(1, entity.getEmail());
            pst.setString(2, entity.getPassword());
            pst.setString(3, entity.getFirstName());
            pst.setString(4, entity.getLastName());
            pst.setString(5, entity.getImage());
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
    public List<User> findAll() {
        Connection connection = ConnectionManager.getInstance();
        String query = "SELECT id,email, password, firstName, lastName, image FROM users";
        List<User> userList = new ArrayList<>();

        try (Statement pst = connection.createStatement()) {
            ResultSet result = pst.executeQuery(query);

            while (result.next()) {
                User user = new User(
                        result.getInt("id"),
                        result.getString("email"),
                        result.getString("password"),
                        result.getString("firstName"),
                        result.getString("lastName"),
                        result.getString(("image"))
                );
                userList.add(user);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return userList;
    }

    @Override
    public User findById(Integer integer) {
        return null;
    }

    @Override
    public void update(User entity) {
        Connection connection = ConnectionManager.getInstance();
        String query = "UPDATE users SET email = ?,password = ?,firstName=?,lastName=?,image=? WHERE id = ?";
        try (PreparedStatement pst = connection.prepareStatement(query)) {
            pst.setString(1, entity.getEmail());
            pst.setString(2, entity.getPassword());
            pst.setString(3, entity.getFirstName());
            pst.setString(4, entity.getLastName());
            pst.setString(5, entity.getImage());
            pst.setInt(6, entity.getId());
            pst.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void delete(User entity) {

    }
    public User findByEmail(String emailFind) {
        User userFound = null;
        Connection connection = ConnectionManager.getInstance();
        String query = "SELECT id, email, password, firstName, lastName, image  FROM users WHERE email=?";
        try(PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setString(1, emailFind);
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                int id = resultSet.getInt("id");
                String email = resultSet.getString("email");
                String password = resultSet.getString("password");
                String firstName = resultSet.getString("firstName");
                String lastName = resultSet.getString("lastName");
                String image = resultSet.getString("image");
                userFound = new User(id, email, password, firstName,lastName,image);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return userFound;
    }
}
