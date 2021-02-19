package com.api.produto.indicator;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.availability.AvailabilityChangeEvent;
import org.springframework.boot.availability.LivenessState;
import org.springframework.boot.availability.ReadinessState;
import org.springframework.context.ApplicationContext;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.Calendar;

@Component
@EnableScheduling
public class ApplicationAvailabilityIndicator {

    @Autowired
    private ApplicationContext appContext;

    Calendar timeToUnRead;
    Calendar timeToUnHealth;

    public void unReadFor(int time) {
        Calendar unreadfor = Calendar.getInstance();
        timeToUnRead = unreadfor;
        timeToUnRead.add(Calendar.SECOND, time);
    }

    public void unHealthFor(int time) {
        Calendar unreadfor = Calendar.getInstance();
        timeToUnHealth = unreadfor;
        timeToUnHealth.add(Calendar.SECOND, time);
    }

    @Scheduled(fixedRate = 1000)
    private void verifyLivenessState() {
        Calendar current = Calendar.getInstance();
        if (current.before(timeToUnHealth)) {
            AvailabilityChangeEvent.publish(appContext, LivenessState.BROKEN);
        } else {
            AvailabilityChangeEvent.publish(appContext, LivenessState.CORRECT);
        }
    }

    @Scheduled(fixedRate = 1000)
    private void verifyReadinessState() {
        Calendar current = Calendar.getInstance();
        if (current.before(timeToUnRead)) {
            AvailabilityChangeEvent.publish(appContext, ReadinessState.REFUSING_TRAFFIC);
        } else {
            AvailabilityChangeEvent.publish(appContext, ReadinessState.ACCEPTING_TRAFFIC);
        }
    }

}

