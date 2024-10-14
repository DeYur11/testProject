package com.example.demo.model_model.services;

import com.example.demo.repositories.EmployeeRepository;
import com.example.demo.threads_part.ThreadController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class WorkerService {

    @Autowired
    private EmployeeRepository employeeRepository;

    @Autowired
    private ThreadController threadController;

    public void startWorker(int workerId) {
        threadController.resumeWorker(workerId);  // Start worker in a separate thread
    }

    public void stopWorker(int workerId) {
        threadController.stopWorker(workerId);  // Stop worker thread
    }

    public boolean isWorkerRunning(int workerId) {
        return threadController.isWorkerRunning(workerId);
    }
}
