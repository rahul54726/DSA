package com.CollectionFrameWorks.Queues;

public class QueueMain {
    public static void main(String[] args) throws Exception {
       CustomQueue<Integer> queue=new CustomQueue<>();
        queue.insert(10);
        queue.insert(20);
        queue.insert(30);
        queue.insert(40);
        queue.insert(50);
//        Deque q=new Deque();
        queue.insert(60);
        System.out.println(queue.remove());
        System.out.println(queue.remove());
        System.out.println(queue.front());
        queue.display();
        System.out.println();
        System.out.println(queue.removeCircular());
        System.out.println(queue.removeCircular());
        System.out.println(queue.removeCircular());

    }
}
