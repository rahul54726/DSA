package com.CollectionFrameWorks.Queues;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.LinkedList;

public class InbuildDeque {
    public static void main(String[] args) {
        Deque<Integer> deque =new ArrayDeque<>();
        deque.add(23);
        deque.addFirst(22);
        deque.addLast(24);
        deque.addLast(25);
        deque.addFirst(35);
        deque.removeLast();
        System.out.println(deque.toString());

    }

}
