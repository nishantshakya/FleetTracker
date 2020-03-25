package com.shakya.controller;

import com.fasterxml.jackson.annotation.JsonView;
import com.shakya.entity.Reading;
import com.shakya.repository.specs.ReadingSpecification;
import com.shakya.repository.specs.SearchCriteria;
import com.shakya.repository.specs.SearchOperation;
import com.shakya.service.ReadingService;
import com.shakya.views.Views;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.beans.factory.ObjectFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.Calendar;
import java.util.List;
import java.util.Map;

@RestController
@CrossOrigin
@RequestMapping(value = "readings")
@Api(tags = {"Vehicle Readings Endpoints to get Vehicle Historical Readings and Critical Alerts"})
public class ReadingController {

    @Autowired
    ReadingService readingService;

    @Autowired
    private ObjectFactory<ReadingSpecification> readingSpecificationObjectFactory;

    @PostMapping(value = "", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public Reading save(@RequestBody Reading reading){
        return readingService.save(reading);
    }

    //JSON views vs JPA projections
    @JsonView(Views.Alerts.class)
    @GetMapping(value = "alerts/search", produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation(value = "Find all Vehicle Alerts",
            notes = "Returns a list of Vehicles Alerts"
    )
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "OK"),
            @ApiResponse(code = 404, message = "Not Found"),
            @ApiResponse(code = 500, message = "Internal Server Error")
    })
    public List<Reading> findHistoricalAlerts(@RequestParam Map<String, Object> requestParams){
        ReadingSpecification readingSpecification = readingSpecificationObjectFactory.getObject();
        readingSpecification.add(new SearchCriteria("hasAlerts", true, SearchOperation.EQUAL));
        Sort sort = Sort.by("vin");
        if (requestParams.containsKey("priority"))
            readingSpecification.add(new SearchCriteria("priority",  requestParams.get("priority"), SearchOperation.EQUAL));
        if (requestParams.containsKey("vin"))
            readingSpecification.add(new SearchCriteria("vin", requestParams.get("vin"), SearchOperation.EQUAL));
        if (requestParams.containsKey("hours"))
            readingSpecification.add(new SearchCriteria("timestamp", requestParams.get("hours"), SearchOperation.GREATER_THAN_EQUAL));
        if (requestParams.containsKey("sort"))
            sort = Sort.by((String) requestParams.get("sort"));
        if (requestParams.containsKey("order") && requestParams.get("order").toString().equalsIgnoreCase("desc"))
            sort = sort.descending();
        return readingService.findAll(readingSpecification, sort);
    }

    //JSON views vs JPA projections
    @JsonView(Views.Location.class)
    @GetMapping(value = "location/search", produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation(value = "Find vehicle's locations within certain minutes",
            notes = "Returns a list of vehicle's location within certain minutes"
    )
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "OK"),
            @ApiResponse(code = 404, message = "Not Found"),
            @ApiResponse(code = 500, message = "Internal Server Error")
    })
    public List<Reading> findLocations(@RequestParam("vin") String vin, @RequestParam Map<String, String> requestParams){
        if (requestParams.containsKey("minutes")){
            Calendar before = Calendar.getInstance();
            before.add(Calendar.MINUTE, - Integer.parseInt(requestParams.get("minutes")));
            return readingService.findAllByVinAndTimestampAfter(vin, before.getTime());
        }else{
            return readingService.findAllByVin(vin);
        }
    }
}
