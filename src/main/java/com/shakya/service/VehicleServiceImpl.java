package com.shakya.service;

import com.shakya.entity.Vehicle;
import com.shakya.exception.ResourceNotFoundException;
import com.shakya.repository.VehicleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class VehicleServiceImpl implements VehicleService{

    @Autowired
    VehicleRepository vehicleRepository;

    @Transactional(readOnly = true)
    @Override
    public List<Vehicle> findAll() {
        return (List<Vehicle>) vehicleRepository.findAll();
    }

    @Transactional
    @Override
    public List<Vehicle> add(List<Vehicle> vehicles) {
        return (List<Vehicle>) vehicleRepository.saveAll(vehicles);
    }

    @Transactional(readOnly = true)
    @Override
    public Vehicle findOne(String id) {
        Optional<Vehicle> existing = vehicleRepository.findById(id);
        if (!existing.isPresent()) {
            throw new ResourceNotFoundException("Vehicle with vin " + id + " doesn't exist.");
        }
        return existing.get();
    }
}
