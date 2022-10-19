package com.sbk.MicroserviceBasedApplication.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Vehicle")
public class Vehicle {
    /*
    vehicle_id
    vehicle_model
    vehicle_number
    color
    availability_status
    vehicle_image_url
    */    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long vehicle_id;
    @Column(name = "model", nullable = false)
    private String vehicle_model;
    @Column(name = "number", nullable = false)
    private String vehicle_number;
    @Column(name = "color", nullable = false)
    private String vehicle_color;
    @Column(name = "availability", nullable = false)
    private boolean availability_status;
    @Column(name = "url", nullable = false)
    private boolean vehicle_image_url;
    public long getVehicle_id() {
        return vehicle_id;
    }
    public void setVehicle_id(long vehicle_id) {
        this.vehicle_id = vehicle_id;
    }
    public String getVehicle_model() {
        return vehicle_model;
    }
    public void setVehicle_model(String vehicle_model) {
        this.vehicle_model = vehicle_model;
    }
    public String getVehicle_number() {
        return vehicle_number;
    }
    public void setVehicle_number(String vehicle_number) {
        this.vehicle_number = vehicle_number;
    }
    public String getVehicle_color() {
        return vehicle_color;
    }
    public void setVehicle_color(String vehicle_color) {
        this.vehicle_color = vehicle_color;
    }
    public boolean isAvailability_status() {
        return availability_status;
    }
    public void setAvailability_status(boolean availability_status) {
        this.availability_status = availability_status;
    }
    public boolean isAvehicle_image_url() {
        return vehicle_image_url;
    }
    public void setAvehicle_image_url(boolean avehicle_image_url) {
        this.vehicle_image_url = avehicle_image_url;
    }
}
