package com.sbk.MicroserviceBasedApplication.service;

import java.util.List;

import com.sbk.MicroserviceBasedApplication.model.Dish;

public interface DishService {
    public Dish save(Dish dish);
    public List<Dish> getAllDishes();
    public Dish getDishById(long id);
    public Dish updateDishById(long id, Dish dish);
    public boolean deleteDishById(long id);

    public List<Dish> getAllDishByCategory(String category);

    public List<Dish> getAllDishByPrice(int min, int max);
    public List<Dish> getAllDishByRating(int min, int max);

}

// https://www.youtube.com/watch?v=VZjs6-_yccw&ab_channel=LearnProgrammingYourself