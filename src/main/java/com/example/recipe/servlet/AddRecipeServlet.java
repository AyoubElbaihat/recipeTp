package com.example.recipe.servlet;

import com.example.recipe.model.Category;
import com.example.recipe.service.CategoryService;
import com.example.recipe.service.RecipeService;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.Date;
import java.util.List;

@WebServlet(urlPatterns = AddRecipeServlet.URL)
public class AddRecipeServlet extends HttpServlet {
    public static final String URL = "/auth/add-recipe";

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<Category> categories = new CategoryService().fetchAllCategory();
        req.setAttribute("categories", categories);
        req
                .getRequestDispatcher("/WEB-INF/add-recipe-form.jsp")
                .forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String recipeName = req.getParameter("recipeName");
        String description = req.getParameter("description");
        String imageRecipe = req.getParameter("imageRecipe");
        String difficulty = req.getParameter("difficulty");
        int preparationTime = Integer.parseInt(req.getParameter("preparationTime"));
        int idCategory = Integer.parseInt(req.getParameter("idCategory"));
        try {
            new RecipeService().createRecipe(recipeName,description,imageRecipe,difficulty,preparationTime,idCategory);
            resp.sendRedirect("list-recipe");
        } catch (NumberFormatException e) {
            e.printStackTrace();
            resp.sendRedirect(req.getContextPath() + AddRecipeServlet.URL + "?error=true");
        }
    }
}

