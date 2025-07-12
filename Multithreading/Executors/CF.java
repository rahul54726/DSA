package com.Multithreading.Executors;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

public class CF {
    public static void main(String[] args) {
        CompletableFuture<String> completableFuture = CompletableFuture.supplyAsync(() ->
        {
            try {
                Thread.sleep(5000);
                System.out.println("Worker Thread...");
            } catch (Exception e) {

            }
            return "OK";
        });
        try {
            System.out.println(completableFuture.get());
        } catch (InterruptedException|ExecutionException e) {
            throw new RuntimeException(e);
        }
        System.out.println("Main");
    }
}
