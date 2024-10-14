package com.example.demo.model_model.services;

import com.example.demo.model.CustomPizza;
import com.example.demo.threads_part.TaskBuffer;
import com.example.demo.threads_part.TaskQueue;
import com.example.demo.threads_part.WorkerPool;
import com.example.demo.threads_part.WorkerTask;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;
@Service
public class PizzaService {

    private final TaskQueue taskQueue;
    private final TaskBuffer taskBuffer;

    @Autowired
    public PizzaService(TaskQueue taskQueue, TaskBuffer taskBuffer, WorkerPool workerPool) {
        this.taskQueue = taskQueue;
        this.taskBuffer = taskBuffer;
    }

    public void createPizza(CustomPizza pizzaRequest) {
        // Створення 4 завдань для кожної піци
        List<WorkerTask> tasks = Arrays.asList(
                new WorkerTask("Приготування тіста", pizzaRequest.getId()),
                new WorkerTask("Додавання начинки", pizzaRequest.getId()),
                new WorkerTask("Випічка", pizzaRequest.getId()),
                new WorkerTask("Упаковка", pizzaRequest.getId())
        );

        // Додаємо всі завдання в чергу
        tasks.forEach(task -> {
            if (workerPoolIsBusy()) {
                System.out.println("Всі працівники зайняті. Додаємо завдання у буфер.");
                taskBuffer.addTaskToBuffer(task);
            } else {
                taskQueue.addTask(task);  // Додаємо завдання в чергу
            }
        });

        // Перевіряємо, чи можемо взяти завдання з буфера
        if (!taskBuffer.isEmpty()) {
            taskQueue.addTask(taskBuffer.getTaskFromBuffer());
        }
    }

    private boolean workerPoolIsBusy() {
        // Логіка, щоб перевірити, чи всі працівники зайняті (наприклад, черга занадто велика)
        return taskQueue.isEmpty();
    }
}
