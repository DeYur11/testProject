package com.example.demo.threads_part;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

@Component
public class ThreadController {

    private final TaskQueue taskQueue;

    private final Map<Integer, Thread> workerThreads = new HashMap<>();

    // Map to track paused state for workers
    private final Map<Integer, Boolean> workerPausedState = new HashMap<>();

    private int workerIdCounter = 1;  // Counter to assign unique worker IDs

    @Autowired
    public ThreadController(TaskQueue taskQueue) {
        this.taskQueue = taskQueue;
    }

    public void start(int numberOfWorkers) {
        for (int i = 0; i < numberOfWorkers; i++) {
            int workerId = workerIdCounter++;
            workerPausedState.put(workerId, false);  // Initially, workers are not paused

            Thread workerThread = new Thread(() -> {
                try {
                    while (!Thread.currentThread().isInterrupted()) {
                        synchronized (workerPausedState) {
                            // Wait if this worker is paused
                            while (workerPausedState.get(workerId)) {
                                System.out.println("Worker " + workerId + " is paused.");
                                workerPausedState.wait();  // Wait until resumed
                            }
                        }

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

    // Pause a specific worker
    public synchronized void pauseWorker(int workerId) {
        if (workerThreads.containsKey(workerId)) {
            synchronized (workerPausedState) {
                workerPausedState.put(workerId, true);
                System.out.println("Worker " + workerId + " has been paused.");
            }
        } else {
            System.out.println("Worker " + workerId + " does not exist.");
        }
    }

    // Resume a specific worker
    public synchronized void resumeWorker(int workerId) {
        if (workerThreads.containsKey(workerId)) {
            synchronized (workerPausedState) {
                workerPausedState.put(workerId, false);
                workerPausedState.notifyAll();  // Notify workers that they can continue
                System.out.println("Worker " + workerId + " has been resumed.");
            }
        } else {
            System.out.println("Worker " + workerId + " does not exist.");
        }
    }

    // Stop a specific worker
    public synchronized void stopWorker(int workerId) {
        Thread workerThread = workerThreads.get(workerId);

        if (workerThread != null && workerThread.isAlive()) {
            workerThread.interrupt();  // Interrupt the worker thread
            workerThreads.remove(workerId);  // Remove from the map
            workerPausedState.remove(workerId);  // Clean up paused state
            System.out.println("Worker " + workerId + " has been stopped.");
        } else {
            System.out.println("Worker " + workerId + " is not running.");
        }
    }

    // Stop all workers
    public synchronized void stopAllWorkers() {
        for (Integer workerId : workerThreads.keySet()) {
            stopWorker(workerId);
        }
        System.out.println("All workers have been stopped.");
    }

    // Check if a specific worker is running
    public synchronized boolean isWorkerRunning(int workerId) {
        Thread workerThread = workerThreads.get(workerId);
        return workerThread != null && workerThread.isAlive();
    }
}
