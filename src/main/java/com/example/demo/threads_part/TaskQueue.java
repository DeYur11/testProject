package com.example.demo.threads_part;

import lombok.Setter;
import org.springframework.stereotype.Component;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

@Component
public class TaskQueue {
    private final BlockingQueue<WorkerTask> taskQueue = new LinkedBlockingQueue<>();
    @Setter
    private NextTaskStrategy nextTaskStrategy;

    // Додає нове завдання в чергу
    public void addTask(WorkerTask task) {
        taskQueue.offer(task);
    }

    // Отримує наступне завдання
    public WorkerTask getNextTask() throws InterruptedException {
        return nextTaskStrategy.nextTask(taskQueue);
    }

    public boolean isEmpty() {
        return taskQueue.isEmpty();
    }

}
