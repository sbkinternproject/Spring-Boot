package com.sbk.MicroserviceBasedApplication.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.sbk.MicroserviceBasedApplication.model.Vehicle;
import com.sbk.MicroserviceBasedApplication.service.VehicleService;

@CrossOrigin(origins = "*", allowedHeaders = "*")
@RestController
@RequestMapping("/Vehicle")
public class VehicleController {
    private VehicleService vehicleService;

    public VehicleController(VehicleService vehicleService) {
        this.vehicleService = vehicleService;
    }
    @GetMapping()
    @ResponseBody
    public String homePage(){
        return "<h1><center>Welcome to Vehicle By Chirag19CSU071</center></h1>";
    }
    @PostMapping("/save")
    public ResponseEntity<Vehicle> saveExpense(@RequestBody Vehicle vehicle){
        return new ResponseEntity<Vehicle>(vehicleService.save(vehicle), HttpStatus.CREATED);
    }
    @GetMapping("/get")
    public ResponseEntity<List<Vehicle>> get(){
        return new ResponseEntity<List<Vehicle>>(vehicleService.getAllVehicles(), HttpStatus.OK);
    }
    @GetMapping("/getById/{id}")
    public ResponseEntity<Vehicle> getExpenseById(@PathVariable("id") Long id){
        // System.out.println("The Id we are getting is "+id);
        return new ResponseEntity<Vehicle>(vehicleService.getVehicleById(id), HttpStatus.OK);
    }
    @GetMapping("/deleteById/{id}")
    public ResponseEntity<Boolean> deleteExpenseById(@PathVariable("id") Long id){
        // System.out.println("The Id we are getting is "+id);
        return new ResponseEntity<Boolean>(vehicleService.deleteVehicleById(id), HttpStatus.OK);
    }
    @PostMapping("/updateById/{id}")
    public ResponseEntity<Vehicle> updateExpenseById(@PathVariable("id") Long id, @RequestBody Vehicle Vehicle){
        return new ResponseEntity<Vehicle>(vehicleService.updateVehicleById(id, Vehicle), HttpStatus.OK);
    }

}
