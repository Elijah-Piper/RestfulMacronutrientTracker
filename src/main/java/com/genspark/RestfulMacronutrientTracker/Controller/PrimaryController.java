package com.genspark.RestfulMacronutrientTracker.Controller;

import com.genspark.RestfulMacronutrientTracker.Entity.Meal;
import com.genspark.RestfulMacronutrientTracker.Service.MealService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;

@RestController
public class PrimaryController {

    @Autowired
    private MealService mealService;

    @GetMapping("/")
    public String home() {
        return "<HTML>" +
                    "<H1>Welcome to my macronutrient tracker!</H1>" +
                    "<H3>To use, type these endpoints in the URL:</H3>" +
                    "<ul>" +
                        "<li>/allmeals [GET]: For all meals in database</li>" +
                        "<li>/meal/{mealId} [GET]: Get a single meal if you know its database ID</li>" +
                        "<li>/meal/ + mealObjJSON [PUT]: Update a single meal if you know its database ID</li>" +
                        "<li>/addmeal/ + mealObjJSON in request body [POST]: Create a new meal entry" +
                        "<li>/meal/{mealId} [DELETE]: Delete a single meal if you know its database ID</li>" +
                        "<li>/macros [GET]: Gives cumulative sums of each macronutrient</li>" +
                        "<li>/addtestmeals [POST]: Adds three meals to the database for testing</li>" +
                        "<li>/clearmeals [DELETE]: Clears the database of all meals</li>" +
                    "</ul>" +
                "</HTML>";

    }

    @GetMapping("/allmeals")
    public List<Meal> getMeals() {
        return this.mealService.getAllMeals();
    }

    @GetMapping("/meal/{mealId}")
    public Meal getMeal(@PathVariable int mealId) {
        return this.mealService.getMealById(mealId);
    }

    @PostMapping("/addmeal")
    public Meal addMeal(@RequestBody Meal meal) {
        return this.mealService.addMeal(meal);
    }

    @PutMapping("/meal")
    public Meal updateMeal(@RequestBody Meal meal) {
        return this.mealService.updateMeal(meal);
    }

    @DeleteMapping("/delete/{mealId}")
    public String deleteMeal(@PathVariable int mealId) {
        return this.mealService.deleteMealById(mealId);
    }

    @GetMapping("/macros")
    public String getMacros() {
        HashMap<String, Integer> macros = this.mealService.getMacros();

        return "<HTML><H3>Macros from currently recorded meals</H3><ul><li>Calories: %d</li><li>Protein: %d</li><li>Carbohydrates: %d</li><li>Fat: %d</li></ul></HTML>".formatted(macros.get("cal"), macros.get("p"), macros.get("c"), macros.get("f"));
    }

    @PostMapping("/addtestmeals")
    public String addTestMeals() {
        return this.mealService.addTestMeals();
    }

    @DeleteMapping("/clearmeals")
    public String clearMeals() {
        return this.mealService.deleteAllMeals();
    }
}
