package org.vano.scheduler.task;

import java.time.LocalDateTime;

/**
 * Created by vano on 3.2.19.
 */
public class CustomTask implements Runnable {

    private String name;

    public CustomTask(String name) {
        this.name = name;
    }

    @Override
    public void run() {
        System.out.println(LocalDateTime.now() + " : Run task: " + name);
    }

    public String getName() {
        return name;
    }
}
