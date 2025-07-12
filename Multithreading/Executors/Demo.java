package com;

import java.util.concurrent.*;

public class Demo {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        ExecutorService executorService = Executors.newSingleThreadExecutor();
        Callable<String> call = () -> "Hello";
        Runnable run = () -> System.out.println("hello");
        Future<?> future =executorService.submit(run);
//        System.out.println(future.get());
        executorService.submit(run,"abc");
        executorService.shutdown();
        ExecutorService es = Executors.newFixedThreadPool(2);
        Future<Integer> submit = es.submit(() -> 1+2);
        Integer i = submit.get();
        System.out.println("Sum is : " + i);
        es.shutdown();
        Thread.sleep(1);
        System.out.println(es.isTerminated());
    }
}
