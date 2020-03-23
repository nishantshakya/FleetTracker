package com.shakya.rules;

import com.shakya.entity.Alert;
import com.shakya.entity.Reading;
import org.jeasy.rules.annotation.Action;
import org.jeasy.rules.annotation.Condition;
import org.jeasy.rules.annotation.Fact;
import org.jeasy.rules.annotation.Rule;

import java.util.List;

@Rule(name = "tire pressure rule", description = "tire pressure of any tire < 32psi || > 36psi", priority = 1)
public class TirePressureRule {
    @Condition
    public boolean when(@Fact("reading") Reading reading) {
        return  (reading.getTires().getRearLeft() < 32.0 || reading.getTires().getRearLeft() > 36.0 ||
                reading.getTires().getRearRight() < 32.0 || reading.getTires().getRearRight() > 36.0 ||
                reading.getTires().getFrontLeft() < 32.0 || reading.getTires().getFrontLeft() > 36.0 ||
                reading.getTires().getFrontRight() < 32.0 || reading.getTires().getFrontRight() > 36.0);

    }

    @Action
    public void then(@Fact("alerts") List<Alert> alerts) {
        Alert alert = new Alert();
        alert.setDescription(TirePressureRule.class.getAnnotation(Rule.class).description());
        alert.setPriority(TirePressureRule.class.getAnnotation(Rule.class).priority());
        alerts.add(alert);
    }

}
