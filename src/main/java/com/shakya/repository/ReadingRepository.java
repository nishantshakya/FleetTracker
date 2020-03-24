package com.shakya.repository;

import com.shakya.entity.Reading;
import com.shakya.entity.ReadingPK;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface ReadingRepository extends CrudRepository<Reading, ReadingPK>, JpaSpecificationExecutor<Reading> {

    List<Reading> findByVin(String vin);
//    List<Reading> findByAlerts_Priority(Integer priority);
}
