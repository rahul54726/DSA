package com.LeetCode.priorityQueue;

import java.util.ArrayList;
import java.util.Collections;
import java.util.PriorityQueue;
import java.util.stream.Collector;
import java.util.stream.Collectors;

public class MedianFinder {
    PriorityQueue<Integer> upperHalf;
    PriorityQueue<Integer> lowerHalf;
    public MedianFinder() {
        lowerHalf = new PriorityQueue<>((a,b) ->b-a);
        upperHalf = new PriorityQueue<>();
    }

    public void addNum(int num) {
        lowerHalf.offer(num);
        upperHalf.offer(lowerHalf.poll());
        if(lowerHalf.size() < upperHalf.size()){
            lowerHalf.offer(upperHalf.poll());
        }
    }

    public double findMedian() {
        if(lowerHalf.size()  > upperHalf.size()){
            return lowerHalf.peek();
        }else {
            if(lowerHalf.isEmpty()) return 0.0;
            return (lowerHalf.peek() + upperHalf.peek() )/ 2.0;
        }
    }

    public static void main(String[] args) {
        MedianFinder medianFinder = new MedianFinder();
        medianFinder.addNum(1);
        medianFinder.addNum(2);
        System.out.println(medianFinder.findMedian());
        medianFinder.addNum(2);
        System.out.println(medianFinder.findMedian());
    }
}
