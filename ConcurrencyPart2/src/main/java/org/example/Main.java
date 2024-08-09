package org.example;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.concurrent.*;

public class Main {
    public static void main(String[] args) {

        ExecutorService executorService = Executors.newSingleThreadExecutor();
        CountDownLatch countDownLatch = new CountDownLatch(3);
        Runnable task1 = new Runnable() {
            @Override
            public void run() {
                long sum = 0;
                for (int i=0; i <= 1_000_000; i++){
                    if ( i % 2 == 0) sum+=i;
                }
                System.out.println("Task1: " + sum );
                countDownLatch.countDown();
            }
        };

        Runnable task2 = new Runnable() {
            @Override
            public void run() {
                long sum = 0;
                for (int i=0; i <= 1_000_000; i++){
                    if ( i % 7 == 0) sum+=i;
                }
                System.out.println("Task1: " + sum );
                countDownLatch.countDown();
            }
        };

        Runnable task3 = new Runnable() {
            @Override
            public void run() {
                List<Integer> numbers = new ArrayList<>();
                for (int i=0; i <= 1000; i++){
                    numbers.add((int)(Math.random() * 1000));
                }
                int count = 0;
                for (int i : numbers){
                    if (i % 2 == 0) {
                        count++;
                    }
                }
                System.out.println("Task3: " + count);
                countDownLatch.countDown();
            }
        };
        long before = System.currentTimeMillis();
        executorService.execute(task1);
        executorService.execute(task2);
        executorService.execute(task3);
        executorService.shutdown();
        try {
            countDownLatch.await();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        long after = System.currentTimeMillis();
        System.out.println("Time: " + (after - before));
    }
}