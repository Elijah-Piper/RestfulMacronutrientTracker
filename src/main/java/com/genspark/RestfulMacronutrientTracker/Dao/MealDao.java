package com.genspark.RestfulMacronutrientTracker.Dao;

import com.genspark.RestfulMacronutrientTracker.Entity.Meal;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MealDao extends JpaRepository<Meal, Integer> {
}
