package com.shakya.controller;

import com.shakya.entity.Vehicle;
import com.shakya.service.VehicleService;
import io.swagger.annotations.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping(value = "vehicles")
@Api(tags = {"Vehicle Metadata Endpoints"})
public class VehicleController {

    @Autowired
    VehicleService vehicleService;

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation(value = "Find all Vehicles",
            notes = "Returns a list of all Vehicles"
    )
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "OK"),
            @ApiResponse(code = 500, message = "Internal Server Error")
    })
    public List<Vehicle> findAll(){
        return vehicleService.findAll();
    }

    @GetMapping(value = "{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation(value = "Find one Vehicle by vin",
            notes = "Returns a single vehicle by vin or throws 404"
    )
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "OK"),
            @ApiResponse(code = 404, message = "Not Found"),
            @ApiResponse(code = 500, message = "Internal Server Error")
    })
    public Vehicle findOne(
            @ApiParam(value = "vin of requested vehicle", required = true) @PathVariable("id") String id){
        return vehicleService.findOne(id);
    }

    @PutMapping(value = "", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation(value = "Batch upsert list of vehicles",
            notes = "Returns a list of upserted vehicles"
    )
    @ApiResponses({
            @ApiResponse(code = 200, message = "OK"),
            @ApiResponse(code = 404, message = "Not Found"),
            @ApiResponse(code = 500, message = "Internal Server Error")
    })
    public List<Vehicle> add(@RequestBody List<Vehicle> vehicles){
        return vehicleService.add(vehicles);
    }
}
