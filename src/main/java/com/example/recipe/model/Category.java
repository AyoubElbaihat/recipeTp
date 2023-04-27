package com.example.recipe.model;

public class Category {
    private int id;
    private String nameCategory;

    public Category(int id, String nameCategory) {
        this.id = id;
        this.nameCategory = nameCategory;
    }

    public int getId() {
        return id;
    }

    public String getNameCategory() {
        return nameCategory;
    }
}
