package com.shakya.controller;

import com.shakya.entity.Reading;
import com.shakya.service.ReadingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin
@RequestMapping(value = "readings")
public class ReadingController {

    @Autowired
    ReadingService readingService;

    @PostMapping(value = "", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public Reading save(@RequestBody Reading reading){
        return readingService.save(reading);
    }

}
