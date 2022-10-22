package com.sbk.MicroserviceBasedApplication.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sbk.MicroserviceBasedApplication.model.Resturant;

public interface ResturantRepository extends JpaRepository<Resturant, Long> {
    
}
