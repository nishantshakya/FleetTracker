package com.shakya.repository;

import com.shakya.entity.Reading;
import org.springframework.data.repository.CrudRepository;

import java.sql.Timestamp;

public interface ReadingRepository extends CrudRepository<Reading, Timestamp> {

}
