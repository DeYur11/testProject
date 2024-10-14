package com.example.demo.threads_part;

import java.util.concurrent.BlockingQueue;

public interface NextTaskStrategy {
    WorkerTask nextTask(BlockingQueue<WorkerTask> queue);
}
