package com.example.recipe.servlet;

import com.example.recipe.model.Recipe;
import com.example.recipe.service.RecipeService;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.List;

@WebServlet(urlPatterns = RandomRecipeServlet.URL)
public class RandomRecipeServlet extends HttpServlet {
    public static final String URL = "/random-recipe";
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        RecipeService recipeService = new RecipeService();
        Recipe randomRecipe = recipeService.fetchRandomLastSixDayRecipes();

        req.setAttribute("randomRecipe", randomRecipe);
        req
                .getRequestDispatcher(req.getContextPath() +"/WEB-INF/random-recipe.jsp")
                .forward(req, resp);
    }
}
