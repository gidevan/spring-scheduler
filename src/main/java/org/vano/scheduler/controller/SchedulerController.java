package org.vano.scheduler.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.vano.scheduler.service.SchedulerService;

/**
 * Created by vano on 3.2.19.
 */
@RestController
@RequestMapping("/scheduler")
public class SchedulerController {

    @Autowired
    private SchedulerService schedulerService;

    @PostMapping("/add/{name}/{period}")
    public void addTask(@PathVariable String name, @PathVariable Long period) {
        schedulerService.addTask(name, period);
    }
}
