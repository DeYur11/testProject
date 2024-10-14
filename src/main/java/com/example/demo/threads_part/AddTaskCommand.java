package com.example.demo.threads_part;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class AddTaskCommand extends TaskCommand{

    @Autowired
    protected AddTaskCommand(TaskQueue taskQueue, TaskBuffer taskBuffer) {
        super(taskQueue, taskBuffer);
    }

    @Override
    public void execute() {

    }
}
