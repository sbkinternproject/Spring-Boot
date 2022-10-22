package com.sbk.MicroserviceBasedApplication.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sbk.MicroserviceBasedApplication.model.Dish;

public interface DishRepository extends JpaRepository<Dish,Long> {
    
}
