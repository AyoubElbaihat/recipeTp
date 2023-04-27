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

@WebServlet(urlPatterns = SearchByCategoryServlet.URL)
public class SearchByCategoryServlet extends HttpServlet {
    public static final String URL = "/auth/search-by-category";
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<Category> categories = new CategoryService().fetchAllCategory();
        req.setAttribute("categories", categories);
        RecipeService recipeService = new RecipeService();
        String research = req.getParameter("research");
        CategoryService categoryService = new CategoryService();
        Category category = categoryService.fetchById(Integer.parseInt(research));
        String nameCategory = category.getNameCategory();
        List<Recipe> recipeList = recipeService.fetchByCategoryName(nameCategory);

        req.setAttribute("recipeList", recipeList);
        req
                .getRequestDispatcher(req.getContextPath() +"/WEB-INF/searched-recipe-by-category.jsp")
                .forward(req, resp);
    }
}
