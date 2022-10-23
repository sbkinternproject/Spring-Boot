package com.sbk.MicroserviceBasedApplication.controller;


import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sbk.MicroserviceBasedApplication.model.Dish;
import com.sbk.MicroserviceBasedApplication.service.DishService;

@CrossOrigin(origins = "*", allowedHeaders = "*")
@RestController
@RequestMapping("/Dish")
public class DishController {
    private DishService dishService;

    public DishController(DishService dishService) {
        this.dishService = dishService;
    }
    @PostMapping("/save")
    public ResponseEntity<Dish> saveExpense(@RequestBody Dish dish){
        return new ResponseEntity<Dish>(dishService.save(dish), HttpStatus.CREATED);
    }
    @GetMapping("/get")
    public ResponseEntity<List<Dish>> get(){
        return new ResponseEntity<List<Dish>>(dishService.getAllDishes(), HttpStatus.OK);
    }
    @GetMapping("/getById/{id}")
    public ResponseEntity<Dish> getExpenseById(@PathVariable("id") Long id){
        // System.out.println("The Id we are getting is "+id);
        return new ResponseEntity<Dish>(dishService.getDishById(id), HttpStatus.OK);
    }
    @DeleteMapping("/deleteById/{id}")
    public ResponseEntity<Boolean> deleteExpenseById(@PathVariable("id") Long id){
        // System.out.println("The Id we are getting is "+id);
        return new ResponseEntity<Boolean>(dishService.deleteDishById(id), HttpStatus.OK);
    }
    @PutMapping("/updateById/{id}")
    public ResponseEntity<Dish> updateExpenseById(@PathVariable("id") Long id, @RequestBody Dish Dish){
        return new ResponseEntity<Dish>(dishService.updateDishById(id, Dish), HttpStatus.OK);
    }

    @GetMapping("/getAllDishByCategory/{category}")
    public ResponseEntity<List<Dish>> getAllDishByCategory(@PathVariable("category") String category){
        return new ResponseEntity<List<Dish>>(dishService.getAllDishByCategory(category), HttpStatus.OK);
    }
    @GetMapping("/getAllDishByPrice/{min}/{max}")
    public ResponseEntity<List<Dish>> getAllDishByPrice(@PathVariable("min") double min, @PathVariable("max") double max){
        return new ResponseEntity<List<Dish>>(dishService.getAllDishByPrice(min, max), HttpStatus.OK);
    }
    @GetMapping("/getAllDishByRating/{min}/{max}")
    public ResponseEntity<List<Dish>> getAllDishByRating(@PathVariable("min") double min, @PathVariable("max") double max){
        return new ResponseEntity<List<Dish>>(dishService.getAllDishByRating(min, max), HttpStatus.OK);
    }

}
