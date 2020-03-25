package com.shakya.service;

import com.shakya.entity.Alert;
import com.shakya.entity.Reading;
import com.shakya.entity.Vehicle;
import com.shakya.repository.VehicleRepository;
import org.jeasy.rules.api.Facts;
import org.jeasy.rules.api.Rules;
import org.jeasy.rules.api.RulesEngine;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Lookup;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class AlertServiceImpl implements AlertService {

    @Autowired
    VehicleRepository vehicleRepository;

    @Autowired
    RulesEngine rulesEngine;

    @Autowired
    Rules rules;

    @Transactional(readOnly = true)
    @Override
    public void generateAlerts(Reading reading) {
        Optional<Vehicle> vehicle = vehicleRepository.findById(reading.getVin());
        if (vehicle.isPresent()) {
            List<Alert> alerts = new ArrayList<>();
            Facts facts = getFacts();
            facts.put("vehicle", vehicle.get());
            facts.put("reading", reading);
            facts.put("alerts", alerts);
            rulesEngine.fire(rules, facts);
            if (!alerts.isEmpty())
                reading.setHasAlerts(true);
            else
                reading.setHasAlerts(false);
            reading.setAlerts(alerts);
        }
    }

    @Lookup
    public Facts getFacts(){
        return null;
    }

}
