package com.example.recipe.servlet;

import com.example.recipe.model.Category;
import com.example.recipe.model.Recipe;
import com.example.recipe.service.CategoryService;
import com.example.recipe.service.RecipeService;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.List;

@WebServlet(urlPatterns = SearchByKeywordServlet.URL)
public class SearchByKeywordServlet extends HttpServlet {
    public static final String URL = "/auth/search-by-keyword";
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        RecipeService recipeService = new RecipeService();
        String research = req.getParameter("research");
        List<Recipe> foundRecipes = recipeService.fetchByKeyword(research);
        req.setAttribute("foundRecipes",foundRecipes);

        req
                .getRequestDispatcher(req.getContextPath() +"/WEB-INF/searched-recipe-by-keyword.jsp")
                .forward(req, resp);
    }
}
