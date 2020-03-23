package com.shakya.rules;

import com.shakya.entity.Alert;
import com.shakya.entity.Reading;
import com.shakya.entity.Vehicle;
import org.jeasy.rules.annotation.Action;
import org.jeasy.rules.annotation.Condition;
import org.jeasy.rules.annotation.Fact;
import org.jeasy.rules.annotation.Rule;

import java.util.List;

@Rule(name = "rpm rule", description = "if engine rpm is higher than redline rpm", priority = 3)
public class RpmRule {
    @Condition
    public boolean when(@Fact("reading") Reading reading, @Fact("vehicle") Vehicle vehicle) {
        return reading.getEngineRpm() > vehicle.getRedlineRpm();
    }

    @Action
    public void then(@Fact("alerts") List<Alert> alerts) {
        Alert alert = new Alert();
        alert.setDescription(RpmRule.class.getAnnotation(Rule.class).description());
        alert.setPriority(RpmRule.class.getAnnotation(Rule.class).priority());
        alerts.add(alert);
    }
}
