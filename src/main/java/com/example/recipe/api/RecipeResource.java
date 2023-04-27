package com.example.recipe.api;

import com.example.recipe.api.dto.RecipeDto;
import com.example.recipe.model.Recipe;
import com.example.recipe.service.RecipeService;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;

@Path("recipes")
public class RecipeResource {
    RecipeService recipeService = new RecipeService();

// ***** Récupérez les recettes en fonction des critères  par exemple  http://localhost:8080/webapi/recipes/entrees
//    @GET
//    @Produces(value = MediaType.APPLICATION_JSON)
//    @Path("/{string}")
//    public Response findbyCategory(@PathParam("string") String string){
//        List<Recipe> recipeList = recipeService.fetchByCategoryName(string);
//        List<RecipeDto> dtoList = new ArrayList<>();
//        for (Recipe c:recipeList) {
//            dtoList.add(c.toDto());
//        }
//        return Response.ok(recipeList).build();
//    }


// ******   Récupérer toutes les recettes (en fonction de l'heure et de l'historique datant de moins de 6 jours)
//    @GET
//    @Produces(value = MediaType.APPLICATION_JSON)
//    public Response findLastSixDayRecipes(){
//        List<Recipe> recipeList = recipeService.fetchLastSixDayRecipes();
//        List<RecipeDto> dtoList = new ArrayList<>();
//        for (Recipe c:recipeList) {
//            dtoList.add(c.toDto());
//        }
//        return Response.ok(dtoList).build();
//    }

// ******   Récupérer une random recette (en fonction de l'heure et de l'historique datant de moins de 6 jours)
    @GET
    @Produces(value = MediaType.APPLICATION_JSON)
        public Response findRandomLastSixDayRecipes(){
        Recipe randomRecipe = recipeService.fetchRandomLastSixDayRecipes();
        RecipeDto recipeDto = randomRecipe.toDto();
        return Response.ok(recipeDto).build();
    }
}
