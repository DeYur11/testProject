package com.example.demo.threads_part;


public class WorkerTask implements Runnable {
    private String taskName;
    private Integer pizzaId;

    public WorkerTask(String taskName, Integer pizzaId) {
        this.taskName = taskName;
        this.pizzaId = pizzaId;
    }

    @Override
    public void run() {
        try {
            // Симуляція виконання завдання
            System.out.println("Виконується завдання " + taskName + " для піци ID: " + pizzaId);
            Thread.sleep(2000);  // Симуляція часу виконання завдання
            System.out.println("Завдання " + taskName + " завершено для піци ID: " + pizzaId);
        } catch (InterruptedException e) {
            System.out.println("Завдання було перервано");
        }
    }
}
