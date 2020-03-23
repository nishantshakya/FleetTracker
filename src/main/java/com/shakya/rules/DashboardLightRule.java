package com.shakya.rules;

import com.shakya.entity.Alert;
import com.shakya.entity.Reading;
import org.jeasy.rules.annotation.Action;
import org.jeasy.rules.annotation.Condition;
import org.jeasy.rules.annotation.Fact;
import org.jeasy.rules.annotation.Rule;

import java.util.List;

@Rule(name = "dashboard light rule", description = "engineCoolantLow = true || checkEngineLightOn = true", priority = 1)
public class DashboardLightRule {

    @Condition
    public boolean when(@Fact("reading") Reading reading) {
        return reading.isEngineCoolantLow() || reading.isCheckEngineLightOn();
    }

    @Action
    public void then(@Fact("alerts") List<Alert> alerts) {
        Alert alert = new Alert();
        alert.setDescription(DashboardLightRule.class.getAnnotation(Rule.class).description());
        alert.setPriority(DashboardLightRule.class.getAnnotation(Rule.class).priority());
        alerts.add(alert);
    }
}
