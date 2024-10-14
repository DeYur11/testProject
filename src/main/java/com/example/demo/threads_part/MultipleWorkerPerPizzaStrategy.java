package com.example.demo.threads_part;

import java.util.concurrent.BlockingQueue;

public class MultipleWorkerPerPizzaStrategy implements NextTaskStrategy{
    @Override
    public WorkerTask nextTask(BlockingQueue<WorkerTask> queue) {
        return null;
    }
}
