package com.sbk.MicroserviceBasedApplication.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sbk.MicroserviceBasedApplication.model.Vehicle;

public interface VehicleRepository extends JpaRepository<Vehicle, Long>{
    
}
