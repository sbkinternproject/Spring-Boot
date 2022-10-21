package com.sbk.MicroserviceBasedApplication.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.sbk.MicroserviceBasedApplication.exception.ResourceNotFoundException;
import com.sbk.MicroserviceBasedApplication.model.Vehicle;
import com.sbk.MicroserviceBasedApplication.repository.VehicleRepository;
import com.sbk.MicroserviceBasedApplication.service.VehicleService;


@Service
public class VehicleServiceImpl implements VehicleService{
    private VehicleRepository vehicleRepository;
    public VehicleServiceImpl(VehicleRepository vehicleRepository) {
        this.vehicleRepository = vehicleRepository;
    }

    @Override
    public Vehicle save(Vehicle vehicle) {
        // TODO Auto-generated method stub
        return vehicleRepository.save(vehicle);
    }

    @Override
    public List<Vehicle> getAllVehicles() {
        // TODO Auto-generated method stub
        return vehicleRepository.findAll();
    }

    @Override
    public Vehicle getVehicleById(long id) {
        // TODO Auto-generated method stub
        return vehicleRepository.findById(id).orElseThrow(()-> new ResourceNotFoundException("Vehicle Not Found", "id", id));
    }

    @Override
    public Vehicle updateVehicleById(long id, Vehicle vehicle) {
        // TODO Auto-generated method stub
        vehicle.setVehicle_id(id);
        return vehicleRepository.save(vehicle);
    }

    @Override
    public Boolean deleteVehicleById(long id) {
        // TODO Auto-generated method stub
        Vehicle vehicle = getVehicleById(id);
        vehicleRepository.delete(vehicle);
        if(vehicleRepository.existsById(id)){
            return false;
        }
        return true;
    }
    
}
