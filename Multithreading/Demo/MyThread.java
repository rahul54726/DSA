package com.Multithreading;

public class MyThread extends Thread{
//    public MyThread(String name){
//        super(name);
//    }
//    @Override
//    public void run() {
////        System.out.println("RUNNING");
////        for(int i = 0;i<5;i++){
////            try {
////                Thread.sleep(1000);
////            } catch (InterruptedException e) {
////                throw new RuntimeException(e);
////            }
////            System.out.println(i);
////        }
//        for (int i = 0;i < 5;i++){
//            System.out.println(Thread.currentThread().getName() + " - Priority : " + Thread.currentThread().getPriority() +
//                    " -  count : "+i);
//            try {
//                Thread.sleep(1000);
//            }catch (Exception e){
//                System.out.println(e.getMessage());
//            }
//        }
//    }

        private Counter counter;
        public MyThread(Counter counter){
            this.counter = counter ;
        }

        @Override
        public void run() {
            for (int i = 0;i<1000;i++){
                counter.increment();
            }
        }

    public static void main(String[] args) throws InterruptedException {
//        MyThread l = new MyThread("Low Priority Thread");
//        MyThread m = new MyThread("Medium Priority Thread");
//        MyThread h = new MyThread("High Priority Thread");
//        l.setPriority(Thread.MIN_PRIORITY);
//        m.setPriority(Thread.NORM_PRIORITY);
//        h.setPriority(Thread.MAX_PRIORITY);
////        System.out.println(t1.getState());
//        l.start();
//        m.start();
//        h.start();
//        System.out.println(t1.getState());
//        Thread.sleep(100);
//        System.out.println(t1.getState());
//        t1.join();
//        System.out.println(t1.getState());
    }

}
