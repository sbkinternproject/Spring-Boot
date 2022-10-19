package com.sbk.MicroserviceBasedApplication.service;

import java.util.List;

import com.sbk.MicroserviceBasedApplication.model.Vehicle;

public interface VehicleService {
    public Vehicle save(Vehicle vehicle);
    public List<Vehicle> getAllVehicles();
    public Vehicle getVehicleById(long id);
    public Vehicle updateVehicleById(long id, Vehicle vehicle);
    public Boolean deleteVehicleById(long id);
}
