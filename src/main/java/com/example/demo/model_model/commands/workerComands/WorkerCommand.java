package com.example.demo.model_model.commands.workerComands;

import com.example.demo.model_model.services.WorkerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public abstract class WorkerCommand {

    @Autowired
    protected WorkerService workerService;

    abstract void execute(Integer id);
}
