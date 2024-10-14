package com.example.demo.threads_part;

import org.springframework.stereotype.Component;

import java.util.LinkedList;
import java.util.Queue;

@Component
public class TaskBuffer {
    private final Queue<WorkerTask> buffer = new LinkedList<>();

    public void addTaskToBuffer(WorkerTask task) {
        buffer.offer(task);
    }

    public WorkerTask getTaskFromBuffer() {
        return buffer.poll();  // Повертає та видаляє завдання з буфера
    }

    public boolean isEmpty() {
        return buffer.isEmpty();
    }
}
