package com.CollectionFrameWorks.fibonacciHeap;

public class Main {
    public static void main(String[] args) {
        FibonacciHeap heap = new FibonacciHeap();

        // Insert nodes
        FibNode n1 = heap.insert(10);
        FibNode n2 = heap.insert(3);
        FibNode n3 = heap.insert(15);
        FibNode n4 = heap.insert(6);

        System.out.println("Min: " + heap.findMin()); // 3

        heap.decreaseKey(n3, 2); // decrease 15 → 2
        System.out.println("New Min after decreaseKey: " + heap.findMin()); // 2

        System.out.println("Extracted Min: " + heap.extractMin()); // 2
        System.out.println("Extracted Min: " + heap.extractMin()); // 3
        System.out.println("Next Min: " + heap.findMin()); // 6
    }
}
