package com.Multithreading.CountDownLatch;

import java.util.concurrent.*;

public class Main {
    public static void main(String[] args) throws InterruptedException, ExecutionException {
//        ExecutorService executorService = Executors.newFixedThreadPool(3);
//       Future<String> future1 = executorService.submit(new DependentService());
//       Future<String> future2 = executorService.submit(new DependentService());
//       Future<String> future3 = executorService.submit(new DependentService());
//
//        future1.get();
//        future2.get();
//        future3.get();
//
        int numService = 3;
        ExecutorService executorService = Executors.newFixedThreadPool(numService);
        CountDownLatch latch = new CountDownLatch(numService);
        executorService.submit(new DependentService(latch));
        executorService.submit(new DependentService(latch));
        executorService.submit(new DependentService(latch));
        latch.await();

        System.out.println("All dependence Services are Finished Starting main Service...");

        executorService.shutdown();
    }
}
class DependentService implements Callable<String> {
    private final CountDownLatch latch;
    public DependentService(CountDownLatch latch){
        this.latch = latch;
    }
    @Override
    public String call() throws Exception {
        try {
            System.out.println(Thread.currentThread().getName() + " Service Started");
            Thread.sleep(2000);
        }finally {
            latch.countDown();
        }
        return "OK";
    }
}
