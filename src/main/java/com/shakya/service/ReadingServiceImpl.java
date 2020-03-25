package com.shakya.service;

import com.shakya.entity.Reading;
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

    @Override
    public List<Reading> findAllByVin(String vin) {
        return readingRepository.findAllByVin(vin);
    }

    @Override
    public List<Reading> findAll(ReadingSpecification specification, Sort sort) {
        return readingRepository.findAll(specification, sort);
    }

    @Override
    public List<Reading> findAllByVinAndTimestampAfter(String vin, Date before) {
        return readingRepository.findAllByVinAndTimestampAfter(vin, before);
    }

}
