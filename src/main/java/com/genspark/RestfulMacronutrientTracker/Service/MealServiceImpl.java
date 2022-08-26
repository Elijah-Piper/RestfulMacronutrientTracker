package com.genspark.RestfulMacronutrientTracker.Service;

import com.genspark.RestfulMacronutrientTracker.Dao.MealDao;
import com.genspark.RestfulMacronutrientTracker.Entity.Meal;
import org.hibernate.cfg.Configuration;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@Service
public class MealServiceImpl implements MealService {

    @Autowired
    private MealDao mealDao;

    @Override
    public List<Meal> getAllMeals() {
        return this.mealDao.findAll();
    }

    @Override
    public Meal getMealById(int mealId) {
        Optional<Meal> m = this.mealDao.findById(mealId);
        Meal meal = null;
        if (m.isPresent()) {
            meal = m.get();
        } else {
            throw new RuntimeException("Meal not found for id :: " + mealId);
        }

        return meal;
    }

    @Override
    public Meal addMeal(Meal meal) {
        return this.mealDao.save(meal);
    }

    @Override
    public Meal updateMeal(Meal meal) {
        return this.mealDao.save(meal);
    }

    @Override
    public String addTestMeals() {
        Meal m1 = new Meal("steak", 179, 26, 0, 8);
        Meal m2 = new Meal("blt", 447, 20, 27, 28);
        Meal m3 = new Meal("ice cream", 273, 5, 31, 15);

        this.mealDao.save(m1);
        this.mealDao.save(m2);
        this.mealDao.save(m3);

        return "Test Meals Successfully Added";
    }

    @Override
    public HashMap<String, Integer> getMacros() {
        HashMap<String, Integer> macros = new HashMap<>(Map.of( // cal for calories, p for protein, c for carbs, and f for fat
                "cal", 0,
                "p", 0,
                "c", 0,
                "f", 0
        ));

        getAllMeals().forEach(meal -> {
            macros.put("cal", macros.get("cal") + meal.getCalories());
            macros.put("p", macros.get("p") + meal.getProtein());
            macros.put("c", macros.get("c") + meal.getCarbohydrates());
            macros.put("f", macros.get("f") + meal.getFat());
        });

        return macros;
    }

    @Override
    public String deleteMealById(int mealId) {
        this.mealDao.deleteById(mealId);
        return "Deleted Successfully";
    }

    @Override
    public String deleteAllMeals() {
        this.mealDao.deleteAll();
        return "Successfully Deleted All Meals";
    }
}
