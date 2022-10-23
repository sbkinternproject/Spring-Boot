package com.sbk.MicroserviceBasedApplication.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.sbk.MicroserviceBasedApplication.model.Resturant;

public interface ResturantRepository extends JpaRepository<Resturant, Long> {
    @Query(value = "SELECT r FROM Resturant r WHERE (r.rating >= :min AND r.rating <= :max)")
    public List<Resturant> findAllResturantByRating(@Param("min") double min, @Param("max") double max);

}
