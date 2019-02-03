package org.vano.scheduler.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.TaskScheduler;
import org.springframework.stereotype.Service;
import org.vano.scheduler.task.CustomTask;
import org.vano.scheduler.task.CustomTrigger;

import java.util.concurrent.ScheduledFuture;

/**
 * Created by vano on 3.2.19.
 */
@Service
public class SchedulerServiceImpl implements SchedulerService {

    @Autowired
    private TaskScheduler taskScheduler;

    @Override
    public void addTask(String name, Long period) {
        CustomTask task = new CustomTask(name);
        CustomTrigger trigger = new CustomTrigger(task, period);
        ScheduledFuture<?> future = taskScheduler.schedule(task, trigger);
        System.out.println("Future: is cancelled" + future.isCancelled());
        System.out.println("Future: is done" + future.isDone());

        //boolean isCancelled = future.cancel(true);
        //System.out.println("isCancelled: " + isCancelled + " future: " + future.isCancelled());

    }
}
