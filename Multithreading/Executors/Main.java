package com.Multithreading.Executors;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;

public class Main {
    public static void main(String[] args) {
        long startTime = System.currentTimeMillis();
        ExecutorService executor = Executors.newFixedThreadPool(10);
        for(int i = 0;i<10;i++){
            int finalI = i;
            Future<?> future = executor.submit(() -> {
                long result = fac(finalI);
                System.out.println(result);
            });
        }
        executor.shutdown();
        try {
        executor.awaitTermination(100, TimeUnit.SECONDS);
        }catch (InterruptedException e){
            Thread.currentThread().interrupt();
        }
        System.out.println("Total time : " + (System.currentTimeMillis()-startTime));
    }
    private static long fac(int n){
        try {
            Thread.sleep(1000);
        }catch (InterruptedException e){
            Thread.currentThread().interrupt();
        }
        int product = 1;
        for(int i = 1;i<=n;i++){
            product*=i;
        }return product;
    }
}
