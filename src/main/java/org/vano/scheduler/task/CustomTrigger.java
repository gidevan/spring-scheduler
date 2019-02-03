package org.vano.scheduler.task;

import org.springframework.scheduling.Trigger;
import org.springframework.scheduling.TriggerContext;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.temporal.ChronoUnit;
import java.time.temporal.TemporalUnit;
import java.util.Date;

/**
 * Created by vano on 3.2.19.
 */
public class CustomTrigger implements Trigger {

    private CustomTask task;
    private Long period;

    public CustomTrigger(CustomTask task, Long period) {
        this.task = task;
        this.period = period;
    }

    @Override
    public Date nextExecutionTime(TriggerContext triggerContext) {
        System.out.println("Trigger: " + task.getName() + " period: " + period);
        LocalDateTime ldt = LocalDateTime.now().plus(period, ChronoUnit.MILLIS);
        return Date.from(ldt.atZone(ZoneId.systemDefault()).toInstant());
    }
}
