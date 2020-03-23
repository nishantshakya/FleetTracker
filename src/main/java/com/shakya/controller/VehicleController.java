package com.shakya.controller;

import com.shakya.entity.Vehicle;
import com.shakya.service.VehicleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping(value = "vehicles")
public class VehicleController {

    @Autowired
    VehicleService vehicleService;

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Vehicle> findAll(){
        return vehicleService.findAll();
    }

    @GetMapping(value = "{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public Vehicle findOne(@PathVariable("id") String id){
        return vehicleService.findOne(id);
    }

    @PutMapping(value = "", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Vehicle> add(@RequestBody List<Vehicle> vehicles){
        return vehicleService.add(vehicles);
    }
}
