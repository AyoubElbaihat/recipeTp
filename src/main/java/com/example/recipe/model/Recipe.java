package com.example.recipe.model;

import com.example.recipe.api.dto.RecipeDto;
import com.example.recipe.dao.crud.RecipeDao;

import java.time.LocalDateTime;
import java.util.Date;

public class Recipe {
    private int id;
    private String recipeName;
    private String description;
    private String imageRecipe;
    private String difficulty;
    private int preparationTime;
    private LocalDateTime dateCreation;
    private Category category;

    public Recipe(int id, String recipeName, String description, String imageRecipe, String difficulty, int preparationTime, LocalDateTime dateCreation, Category category) {
        this.id = id;
        this.recipeName = recipeName;
        this.description = description;
        this.imageRecipe = imageRecipe;
        this.difficulty = difficulty;
        this.preparationTime = preparationTime;
        this.dateCreation = dateCreation;
        this.category = category;
    }

    public Recipe(String recipeName, String description, String imageRecipe, String difficulty, int preparationTime, Category category) {
        this.recipeName = recipeName;
        this.description = description;
        this.imageRecipe = imageRecipe;
        this.difficulty = difficulty;
        this.preparationTime = preparationTime;
        this.dateCreation = LocalDateTime.now();
        this.category = category;
    }

    public int getId() {
        return id;
    }

    public String getRecipeName() {
        return recipeName;
    }

    public String getDescription() {
        return description;
    }

    public String getImageRecipe() {
        return imageRecipe;
    }

    public String getDifficulty() {
        return difficulty;
    }

    public int getPreparationTime() {
        return preparationTime;
    }

    public LocalDateTime getDateCreation() {
        return dateCreation;
    }

    public Category getCategory() {
        return category;
    }

    public void setId(int id) {
        this.id = id;
    }

    public RecipeDto toDto(){
        RecipeDto dto = new RecipeDto();
        dto.setId(this.getId());
        dto.setRecipeName(this.getRecipeName());
        dto.setDescription(this.getDescription());
        dto.setImageRecipe(this.getImageRecipe());
        dto.setDifficulty(this.getDifficulty());
        dto.setPreparationTime(this.getPreparationTime());
        dto.setDateCreation(this.getDateCreation());
        dto.setCategory(this.getCategory());
        return dto;
    }
}
