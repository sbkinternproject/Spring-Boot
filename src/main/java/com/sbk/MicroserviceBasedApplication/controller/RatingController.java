
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

import com.sbk.MicroserviceBasedApplication.model.Rating;
import com.sbk.MicroserviceBasedApplication.service.RatingService;

@CrossOrigin(origins = "*", allowedHeaders = "*")
@RestController
@RequestMapping("/Rating")
public class RatingController {
    private RatingService ratingService;

    public RatingController(RatingService ratingService) {
        this.ratingService = ratingService;
    }
    @PostMapping("/save")
    public ResponseEntity<Rating> saveExpense(@RequestBody Rating rating){
        return new ResponseEntity<Rating>(ratingService.save(rating), HttpStatus.CREATED);
    }
    @GetMapping("/get")
    public ResponseEntity<List<Rating>> get(){
        return new ResponseEntity<List<Rating>>(ratingService.getAllRating(), HttpStatus.OK);
    }
    @GetMapping("/getById/{id}")
    public ResponseEntity<Rating> getExpenseById(@PathVariable("id") Long id){
        // System.out.println("The Id we are getting is "+id);
        return new ResponseEntity<Rating>(ratingService.getRatingById(id), HttpStatus.OK);
    }
    @DeleteMapping("/deleteById/{id}")
    public ResponseEntity<Boolean> deleteExpenseById(@PathVariable("id") Long id){
        // System.out.println("The Id we are getting is "+id);
        return new ResponseEntity<Boolean>(ratingService.deleteRatingById(id), HttpStatus.OK);
    }
    @PutMapping("/updateById/{id}")
    public ResponseEntity<Rating> updateExpenseById(@PathVariable("id") Long id, @RequestBody Rating Rating){
        return new ResponseEntity<Rating>(ratingService.updateRatingById(id, Rating), HttpStatus.OK);
    }
    @GetMapping("/getAllRatingByDishId/{dish_id}")
    public ResponseEntity<List<Rating>> getAllRatingByDishId(@PathVariable("dish_id") long dish_id){
        return new ResponseEntity<List<Rating>>(ratingService.getAllRatingByDishId(dish_id), HttpStatus.OK);
    }
    @GetMapping("/getAllRatingByResturantId/{resturant_id}")
    public ResponseEntity<List<Rating>> getAllRatingByResturantId(@PathVariable("resturant_id") long resturant_id){
        return new ResponseEntity<List<Rating>>(ratingService.getAllRatingByResturantId(resturant_id), HttpStatus.OK);
    }
    @GetMapping("/getAllRatingByUserId/{user_id}")
    public ResponseEntity<List<Rating>> getAllRatingByUserId(@PathVariable("user_id") String user_id){
        return new ResponseEntity<List<Rating>>(ratingService.getAllRatingByUserId(user_id), HttpStatus.OK);
    }


}

