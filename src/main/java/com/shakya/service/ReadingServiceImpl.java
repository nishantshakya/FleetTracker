package com.shakya.service;

import com.shakya.entity.Reading;
import com.shakya.repository.ReadingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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
}
