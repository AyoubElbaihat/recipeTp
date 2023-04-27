package com.example.recipe.api.dto;

import com.example.recipe.model.Category;

import java.time.LocalDateTime;

public class RecipeDto {
    private int id;
    private String recipeName;
    private String description;
    private String imageRecipe;
    private String difficulty;
    private int preparationTime;
    private LocalDateTime dateCreation;
    private Category category;

    public RecipeDto() {
    }

    public RecipeDto(int id, String recipeName, String description, String imageRecipe, String difficulty, int preparationTime, LocalDateTime dateCreation, Category category) {
        this.id = id;
        this.recipeName = recipeName;
        this.description = description;
        this.imageRecipe = imageRecipe;
        this.difficulty = difficulty;
        this.preparationTime = preparationTime;
        this.dateCreation = dateCreation;
        this.category = category;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setRecipeName(String recipeName) {
        this.recipeName = recipeName;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setImageRecipe(String imageRecipe) {
        this.imageRecipe = imageRecipe;
    }

    public void setDifficulty(String difficulty) {
        this.difficulty = difficulty;
    }

    public void setPreparationTime(int preparationTime) {
        this.preparationTime = preparationTime;
    }

    public void setDateCreation(LocalDateTime dateCreation) {
        this.dateCreation = dateCreation;
    }

    public void setCategory(Category category) {
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
}
