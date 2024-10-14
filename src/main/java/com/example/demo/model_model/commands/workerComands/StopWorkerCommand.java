package com.example.demo.model_model.commands.workerComands;

import org.springframework.stereotype.Component;

@Component
public class StopWorkerCommand extends WorkerCommand {
    @Override
    public void execute(Integer id) {
        workerService.stopWorker(id);
    }
}
