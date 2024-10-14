package com.example.demo.model_model.commands.workerComands;

import org.springframework.stereotype.Component;

@Component
public class StartWorkerCommand extends WorkerCommand {
    @Override
    public void execute(Integer workerId) {
        workerService.startWorker(workerId);  // Start the worker in a thread
    }
}