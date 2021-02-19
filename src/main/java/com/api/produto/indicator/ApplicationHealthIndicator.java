package com.api.produto.indicator;

import org.springframework.boot.actuate.health.Health;
import org.springframework.boot.actuate.health.HealthIndicator;
import org.springframework.stereotype.Component;

import java.util.Calendar;

@Component
public class ApplicationHealthIndicator implements HealthIndicator {

    Calendar timeToUnhealth;

    @Override
    public Health health() {
        Calendar current = Calendar.getInstance();
        Health.Builder status;
        status = current.before(timeToUnhealth) ? Health.down() : Health.up();
        return status.build();
    }

}

