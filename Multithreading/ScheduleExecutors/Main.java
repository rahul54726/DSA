package com.Multithreading.ScheduleExecutors;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class Main {
    public static void main(String[] args) {
        ScheduledExecutorService scheduler = Executors.newScheduledThreadPool(2);
        scheduler.scheduleAtFixedRate(
                ()-> System.out.println("Task Executed after every 5 sec delay")
                ,5,
                5,
                TimeUnit.SECONDS);
        scheduler.scheduleWithFixedDelay(()-> System.out.println("Task Executed after every 5 sec delay")
                ,5,
                5,
                TimeUnit.SECONDS);
        scheduler.schedule(() -> {
                System.out.println("Initiating shutdown ...");
                scheduler.shutdown();
        },20,TimeUnit.SECONDS);
    }
}
