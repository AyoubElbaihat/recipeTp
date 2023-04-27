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

@WebServlet(urlPatterns = RecipeDetailServlet.URL)
public class RecipeDetailServlet extends HttpServlet {
    public static final String URL = "/recipe-detail";
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        RecipeService recipeService = new RecipeService();
        int id = Integer.parseInt(req.getParameter("id"));
        Recipe recipe = recipeService.fetchById(id);
        req.setAttribute("recipeName",recipe.getRecipeName());
        req.setAttribute("description",recipe.getDescription());
        req.setAttribute("imageRecipe",recipe.getImageRecipe());
        req.setAttribute("difficulty",recipe.getDifficulty());
        req.setAttribute("preparationTime",recipe.getPreparationTime());
        req.setAttribute("dateCreation",recipe.getDateCreation());
        req.setAttribute("category",recipe.getCategory());
        req
                .getRequestDispatcher(req.getContextPath() +"/WEB-INF/detail-recipe.jsp")
                .forward(req, resp);
    }
}
