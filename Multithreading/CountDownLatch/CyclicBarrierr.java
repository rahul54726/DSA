package com.Multithreading.CountDownLatch;

import java.util.concurrent.*;

public class CyclicBarrierr {
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
        CyclicBarrier barrier = new CyclicBarrier(numService);
        executorService.submit(new DependentService(barrier));
        executorService.submit(new DependentService(barrier));
        executorService.submit(new DependentService(barrier));

        System.out.println("All dependence Services are Finished Starting main Service...");

        executorService.shutdown();
    }
    static class DependentService implements Callable<String> {
        private final CyclicBarrier barrier;
        public DependentService(CyclicBarrier barrier){
            this.barrier = barrier;
        }
        @Override
        public String call() throws Exception {

                System.out.println(Thread.currentThread().getName() + " Service Started");
                Thread.sleep(1000);
                System.out.println(Thread.currentThread().getName() + " is waiting at the barrier .");
                barrier.await();

            return "OK";
        }
    }
}

