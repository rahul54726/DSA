package com.Streams;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Stream;

public class ParallelStream {
    public static void main(String[] args) {
        //Stream that enables parallel processing of elements
        //Allowing multiple threads to process parts of the stream simultaneously
        //this is distributed across multiple threads
        //improves performance for large data sets
        List<Integer> list = Stream.iterate(1, x -> x + 1).limit(20000).toList();
//        list.stream().map(x -> fact(x)).toList();
        List<Long> factorials = list.stream().map(ParallelStream::fact).sequential().toList();
//        System.out.println(factorials);
        //make sure to use in CPU intensive or large datasets where tasks are independent
        //Cumulative Sum
        List<Integer> nums = Arrays.asList(1,2,3,4,5);
        AtomicInteger sum = new AtomicInteger();
//        List<Integer> list1 = nums.parallelStream().map(x -> sum.addAndGet(x)).toList();
        List<Integer> list2 = nums.parallelStream().map(sum::addAndGet).sequential().toList();
        System.out.println(list2);
    }
    private static long fact(int num){
        if(num<=1)return 1;
        return num * fact(num-1);
    }
}
