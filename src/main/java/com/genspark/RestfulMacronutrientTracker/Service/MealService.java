package com.genspark.RestfulMacronutrientTracker.Service;

import com.genspark.RestfulMacronutrientTracker.Entity.Meal;

import java.util.HashMap;
import java.util.List;

public interface MealService {

    List<Meal> getAllMeals();
    Meal getMealById(int mealId);
    Meal addMeal(Meal meal);
    Meal updateMeal(Meal meal);

    String addTestMeals();

    HashMap<String, Integer> getMacros();

    String deleteMealById(int mealId);
    String deleteAllMeals();

}
