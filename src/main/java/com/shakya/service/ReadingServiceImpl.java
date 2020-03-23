package com.shakya.service;

import com.shakya.entity.Reading;
import com.shakya.repository.ReadingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ReadingServiceImpl implements ReadingService {

    @Autowired
    ReadingRepository readingRepository;

    @Override
    public Reading save(Reading reading) {
        return readingRepository.save(reading);
    }
}
