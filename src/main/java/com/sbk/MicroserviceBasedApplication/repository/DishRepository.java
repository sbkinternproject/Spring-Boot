package com.sbk.MicroserviceBasedApplication.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.sbk.MicroserviceBasedApplication.model.Dish;

public interface DishRepository extends JpaRepository<Dish,Long> {
    @Query(value = "SELECT d FROM Dish d WHERE d.category = :category")
    public List<Dish> findAllDishByCategory(@Param("category") String category);

    @Query(value = "SELECT d FROM Dish d WHERE (d.price >= :min AND d.price <= :max)")
    public List<Dish> findAllDishByPrice(@Param("min") double min, @Param("max") double max);

    @Query(value = "SELECT d FROM Dish d WHERE (d.rating >= :min AND d.rating <= :max)")
    public List<Dish> findAllDishByRating(@Param("min") double min, @Param("max") double max);
    
    
}
