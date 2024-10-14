package com.example.demo.threads_part;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public abstract class TaskCommand {
    protected final TaskQueue taskQueue;

    protected final TaskBuffer taskBuffer;

    @Autowired
    protected TaskCommand(TaskQueue taskQueue, TaskBuffer taskBuffer) {
        this.taskQueue = taskQueue;
        this.taskBuffer = taskBuffer;
    }

    public abstract void execute();
}
