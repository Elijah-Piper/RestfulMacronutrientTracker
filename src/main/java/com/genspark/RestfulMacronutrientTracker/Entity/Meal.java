package com.genspark.RestfulMacronutrientTracker.Entity;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

@Entity
public class Meal {

    @Id
    @Column(name="mealId")
    @GeneratedValue(strategy= GenerationType.AUTO)
    private int mealId;
    private String name;
    private int calories;
    private int protein;
    private int carbohydrates;
    private int fat;

    public Meal(int mealId, String name, int calories, int protein, int carbohydrates, int fat) {
        // If no date or time are provided, current time is used
        this.mealId = mealId;
        this.name = name;
        this.calories = calories;
        this.protein = protein;
        this.carbohydrates = carbohydrates;
        this.fat = fat;
    }

    public Meal(String name, int calories, int protein, int carbohydrates, int fat) {
        // If no date or time are provided, current time is used
        this.name = name;
        this.calories = calories;
        this.protein = protein;
        this.carbohydrates = carbohydrates;
        this.fat = fat;
    }

    public Meal() {
    }

    public int getMealId() {
        return mealId;
    }

    public void setMealId(int mealId) {
        this.mealId = mealId;
    }

    public int getCalories() {
        return calories;
    }

    public void setCalories(int calories) {
        this.calories = calories;
    }

    public int getProtein() {
        return protein;
    }

    public void setProtein(int protein) {
        this.protein = protein;
    }

    public int getCarbohydrates() {
        return carbohydrates;
    }

    public void setCarbohydrates(int carbohydrates) {
        this.carbohydrates = carbohydrates;
    }

    public int getFat() {
        return fat;
    }

    public void setFat(int fat) {
        this.fat = fat;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Meal{" +
                "mealId=" + this.mealId +
                ", name=" + this.name +
                ", calories=" + this.calories +
                ", protein=" + this.protein +
                ", carbohydrates=" + this.carbohydrates +
                ", fat=" + this.fat +
                '}';
    }
}
