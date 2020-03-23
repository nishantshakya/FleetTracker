package com.shakya;

import com.shakya.rules.DashboardLightRule;
import com.shakya.rules.FuelVolumeRule;
import com.shakya.rules.RpmRule;
import com.shakya.rules.TirePressureRule;
import org.jeasy.rules.api.Facts;
import org.jeasy.rules.api.Rules;
import org.jeasy.rules.api.RulesEngine;
import org.jeasy.rules.core.DefaultRulesEngine;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;



@Configuration
public class EasyRulesConfig {

    @Bean
    public RulesEngine defaultRules(){
        return new DefaultRulesEngine();
    }

    @Bean
    public Rules rules(){
        Rules rules = new Rules();
        rules.register(new RpmRule());
        rules.register(new FuelVolumeRule());
        rules.register(new DashboardLightRule());
        rules.register(new TirePressureRule());
        return rules;
    }

    @Bean
    @Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE)
    public Facts facts(){
        return new Facts();
    }
}
