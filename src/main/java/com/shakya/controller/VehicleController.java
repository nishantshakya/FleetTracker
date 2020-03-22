package com.shakya.controller;

import com.shakya.entity.Vehicle;
import com.shakya.service.VehicleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "vehicles")
public class VehicleController {

    @Autowired
    VehicleService vehicleService;

    @CrossOrigin
    @PutMapping(value="")
    public List<Vehicle> add(@RequestBody List<Vehicle> vehicles){
        return vehicleService.add(vehicles);
    }
}
