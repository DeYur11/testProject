package com.example.demo.threads_part;

import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

@Component
public class WorkerPool {
    private final TaskQueue taskQueue;
    private final Map<Integer, Thread> workerThreads = new HashMap<>();
    private int workerIdCounter = 1;  // Counter to assign unique worker IDs

    public WorkerPool(TaskQueue taskQueue) {
        this.taskQueue = taskQueue;
    }

    // Start workers and continuously check the queue for tasks
    public void start(int numberOfWorkers) {
        for (int i = 0; i < numberOfWorkers; i++) {
            int workerId = workerIdCounter++;
            Thread workerThread = new Thread(() -> {
                try {
                    while (!Thread.currentThread().isInterrupted()) {
                        WorkerTask task = taskQueue.getNextTask();
                        task.run();  // Execute task
                    }
                } catch (InterruptedException e) {
                    System.out.println("Worker " + workerId + " interrupted.");
                    Thread.currentThread().interrupt();  // Preserve interrupt status
                }
            });

            workerThreads.put(workerId, workerThread);
            workerThread.start();
            System.out.println("Worker " + workerId + " has been started.");
        }
    }

    // Stop a specific worker
    public void stopWorker(int workerId) {
        Thread workerThread = workerThreads.get(workerId);

        if (workerThread != null && workerThread.isAlive()) {
            workerThread.interrupt();  // Interrupt the worker thread
            workerThreads.remove(workerId);  // Remove from the map
            System.out.println("Worker " + workerId + " has been stopped.");
        } else {
            System.out.println("Worker " + workerId + " is not running.");
        }
    }

    // Stop all workers
    public void stopAllWorkers() {
        for (Integer workerId : workerThreads.keySet()) {
            stopWorker(workerId);
        }
        System.out.println("All workers have been stopped.");
    }

    // Check if a specific worker is running
    public boolean isWorkerRunning(int workerId) {
        Thread workerThread = workerThreads.get(workerId);
        return workerThread != null && workerThread.isAlive();
    }
}
