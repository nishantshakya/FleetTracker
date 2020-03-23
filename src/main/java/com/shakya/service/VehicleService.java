package com.shakya.service;

import com.shakya.entity.Vehicle;

import java.util.List;

public interface VehicleService {

    List<Vehicle> findAll();
    List<Vehicle> add(List<Vehicle> vehicles);
    Vehicle findOne(String id);
}
