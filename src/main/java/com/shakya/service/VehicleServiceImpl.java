package com.shakya.service;

import com.shakya.entity.Vehicle;
import com.shakya.repository.VehicleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class VehicleServiceImpl implements VehicleService{

    @Autowired
    VehicleRepository vehicleRepository;

    @Override
    public List<Vehicle> add(List<Vehicle> vehicles) {
        return (List<Vehicle>) vehicleRepository.saveAll(vehicles);
    }
}
