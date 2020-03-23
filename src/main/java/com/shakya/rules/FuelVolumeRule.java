package com.shakya.rules;

import com.shakya.entity.Alert;
import com.shakya.entity.Reading;
import com.shakya.entity.Vehicle;
import org.jeasy.rules.annotation.Action;
import org.jeasy.rules.annotation.Condition;
import org.jeasy.rules.annotation.Fact;
import org.jeasy.rules.annotation.Rule;

import java.util.List;

@Rule(name = "fuel volume rule", description = "fuelVolume < 10% of maxFuelVolume", priority = 2)
public class FuelVolumeRule {
    @Condition
    public boolean when(@Fact("reading") Reading reading, @Fact("vehicle") Vehicle vehicle) {
        return reading.getFuelVolume() < 0.1 * vehicle.getMaxFuelVolume();
    }

    @Action
    public void then(@Fact("alerts") List<Alert> alerts) {
        Alert alert = new Alert();
        alert.setDescription(FuelVolumeRule.class.getAnnotation(Rule.class).description());
        alert.setPriority(FuelVolumeRule.class.getAnnotation(Rule.class).priority());
        alerts.add(alert);
    }
}
