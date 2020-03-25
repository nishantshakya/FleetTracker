package com.shakya.repository;

import com.shakya.entity.Reading;
import com.shakya.entity.ReadingPK;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.CrudRepository;

import java.util.Date;
import java.util.List;

public interface ReadingRepository extends CrudRepository<Reading, ReadingPK>, JpaSpecificationExecutor<Reading> {

    List<Reading> findAllByVin(String vin);
    List<Reading> findAllByVinAndTimestampAfter(String vin, Date before);

}
