package com.sbk.MicroserviceBasedApplication.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.sbk.MicroserviceBasedApplication.exception.ResourceNotFoundException;
import com.sbk.MicroserviceBasedApplication.model.Rating;
import com.sbk.MicroserviceBasedApplication.repository.RatingRepository;
import com.sbk.MicroserviceBasedApplication.service.RatingService;

@Service
public class RatingServiceImpl implements RatingService{
    private RatingRepository ratingRepository;
    public RatingServiceImpl(RatingRepository ratingRepository) {
        this.ratingRepository = ratingRepository;
    }

    @Override
    public Rating save(Rating rating) {
        // TODO Auto-generated method stub
        return ratingRepository.save(rating);
    }

    @Override
    public List<Rating> getAllRating() {
        // TODO Auto-generated method stub
        return ratingRepository.findAll();
    }

    @Override
    public Rating getRatingById(long id) {
        // TODO Auto-generated method stub
        return ratingRepository.findById(id).orElseThrow(()-> new ResourceNotFoundException("Rating", "Id", ratingRepository));
    }

    @Override
    public Rating updateRatingById(long id, Rating rating) {
        // TODO Auto-generated method stub
        rating.setId(id);
        return ratingRepository.save(rating);
    }

    @Override
    public boolean deleteRatingById(long id) {
        // TODO Auto-generated method stub
        Rating rating = getRatingById(id);
        ratingRepository.delete(rating);
        if(ratingRepository.existsById(id)){
            return false;
        }
        return true;
    }

    @Override
    public List<Rating> getAllRatingByDishId(long dish_id) {
        // TODO Auto-generated method stub
        return ratingRepository.findAllRatingByDishId(dish_id);
    }

    @Override
    public List<Rating> getAllRatingByResturantId(long resturant_id) {
        // TODO Auto-generated method stub
        return ratingRepository.findAllRatingByResturantId(resturant_id);
    }

    @Override
    public List<Rating> getAllRatingByUserId(String user_id) {
        // TODO Auto-generated method stub
        return ratingRepository.findAllRatingByUserId(user_id);
    }
    
}
