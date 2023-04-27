package com.example.recipe.service;

import com.example.recipe.dao.jdbc.UserJdbcDao;
import com.example.recipe.model.User;
import jakarta.servlet.http.HttpSession;

public class UserService {
    UserJdbcDao userJdbcDao = new UserJdbcDao();
    public User findUserByEmail(String email){
        return userJdbcDao.findByEmail(email);
    }
    public User createUser(String email, String password, String firstName, String lastName, String image) {
        User userToCreate = new User(email, password,firstName,lastName,image);
        return userJdbcDao.create(userToCreate);
    }

    public void updateUser(User user){
        userJdbcDao.update(user);
    }
}
