package com.sbk.MicroserviceBasedApplication.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sbk.MicroserviceBasedApplication.model.Rating;

public interface RatingRepository extends JpaRepository<Rating, Long>{
    
}
