package com.shakya.service;

import com.shakya.entity.Reading;
import com.shakya.repository.specs.ReadingSpecification;
import org.springframework.data.domain.Sort;

import java.util.List;

public interface ReadingService {
    Reading save(Reading reading);

    List<Reading> findByVin(String vin);

    List<Reading> findAll(ReadingSpecification specification, Sort sort);

//    List<Reading> findByPriority(Integer priority);
}
