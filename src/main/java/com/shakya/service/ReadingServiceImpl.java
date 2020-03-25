package com.shakya.service;

import com.shakya.entity.Reading;
import com.shakya.exception.ResourceNotFoundException;
import com.shakya.repository.ReadingRepository;
import com.shakya.repository.specs.ReadingSpecification;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;

@Service
public class ReadingServiceImpl implements ReadingService {

    @Autowired
    ReadingRepository readingRepository;
    @Autowired
    AlertService alertService;

    @Transactional
    @Override
    public Reading save(Reading reading) {
        alertService.generateAlerts(reading);
        return readingRepository.save(reading);
    }

    @Transactional(readOnly = true)
    @Override
    public List<Reading> findAllByVin(String vin) {
        List<Reading> existing = readingRepository.findAllByVin(vin);
        if (existing.isEmpty()) {
            throw new ResourceNotFoundException("No Readings found for vehicle with vin: " + vin);
        }
        return existing;
    }

    @Transactional(readOnly = true)
    @Override
    public List<Reading> findAll(ReadingSpecification specification, Sort sort) {
        List<Reading> existing = readingRepository.findAll(specification, sort);
        if (existing.isEmpty()) {
            throw new ResourceNotFoundException("No Readings found for given parameters");
        }
        return existing;
    }
    @Transactional(readOnly = true)
    @Override
    public List<Reading> findAllByVinAndTimestampAfter(String vin, Date before) {
        List<Reading> existing = readingRepository.findAllByVinAndTimestampAfter(vin, before);
        if (existing.isEmpty()) {
            throw new ResourceNotFoundException("No Readings found for vehicle with vin: " + vin + " for the given parameter");
        }
        return existing;
    }

}
