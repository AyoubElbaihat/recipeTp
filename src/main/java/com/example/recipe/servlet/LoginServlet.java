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

@WebServlet(urlPatterns = LoginServlet.URL)
public class LoginServlet extends HttpServlet {
    public static final String URL = "/login";
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher(req.getContextPath() +"/WEB-INF/login.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String email = req.getParameter("email");
        String password = req.getParameter("password");
        UserService userService = new UserService();
        User user = userService.findUserByEmail(email);

        if (user != null && user.getPassword().equals(password)) {
            HttpSession session = req.getSession(true);
            session.setAttribute("email", user);
            resp.sendRedirect("/list-recipe");
        } else {
            req.setAttribute("isError", true);
            req.getRequestDispatcher(req.getContextPath() +"/WEB-INF/login.jsp").forward(req, resp);
        }
    }
}
