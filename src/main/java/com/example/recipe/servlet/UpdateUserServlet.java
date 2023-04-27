package com.example.recipe.servlet;

import com.example.recipe.model.User;
import com.example.recipe.service.UserService;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
@WebServlet(urlPatterns = UpdateUserServlet.URL)
public class UpdateUserServlet extends HttpServlet{
    public static final String URL = "/auth/update";
    UserService userService = new UserService();
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        req
                .getRequestDispatcher("/WEB-INF/update-user.jsp")
                .forward(req, resp);
    }
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        Integer id = Integer.parseInt(req.getParameter("id"));
        String email = req.getParameter("email");
        String password = req.getParameter("password");
        String firstName = req.getParameter("firstName");
        String lastName = req.getParameter("lastName");
        String image = req.getParameter("image");


        User updatedUser = new User(id, email,password,firstName,lastName,image);
        userService.updateUser(updatedUser);
        resp.sendRedirect(req.getContextPath() + UpdateUserServlet.URL);
    }
}
