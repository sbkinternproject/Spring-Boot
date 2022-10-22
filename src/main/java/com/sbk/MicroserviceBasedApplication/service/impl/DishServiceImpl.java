package com.sbk.MicroserviceBasedApplication.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.sbk.MicroserviceBasedApplication.exception.ResourceNotFoundException;
import com.sbk.MicroserviceBasedApplication.model.Dish;
import com.sbk.MicroserviceBasedApplication.repository.DishRepository;
import com.sbk.MicroserviceBasedApplication.service.DishService;
@Service
public class DishServiceImpl  implements DishService{
    private DishRepository dishRepository;
    
    public DishServiceImpl(DishRepository dishRepository) {
        this.dishRepository = dishRepository;
    }

    @Override
    public Dish save(Dish dish) {
        // TODO Auto-generated method stub
        return dishRepository.save(dish);
    }

    @Override
    public List<Dish> getAllDishes() {
        // TODO Auto-generated method stub
        return dishRepository.findAll();
    }

    @Override
    public Dish getDishById(long id) {
        // TODO Auto-generated method stub
        return dishRepository.findById(id).orElseThrow(()-> new ResourceNotFoundException("Dish", "Id", dishRepository));
    }

    @Override
    public Dish updateDishById(long id, Dish dish) {
        // TODO Auto-generated method stub
        dish.setId(id);
        return dishRepository.save(dish);
    }

    @Override
    public boolean deleteDishById(long id) {
        // TODO Auto-generated method stub
        Dish dish = getDishById(id);
        dishRepository.delete(dish);
        if(dishRepository.existsById(id)){
            return false;
        }
        return true;
    }

    @Override
    public List<Dish> getAllDishByCategory(String category) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public List<Dish> getAllDishByPrice(int min, int max) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public List<Dish> getAllDishByRating(int min, int max) {
        // TODO Auto-generated method stub
        return null;
    }
    
}
