package com.Streams;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StreamsDemo {
    public static void main(String[] args) {
         // features Introduced in java 8
        // process Collections of data in functional and declarative manner
        //Simplify Data processing
        //Embrace Functional Programming
        //Improve Readability and Maintainability
        //Enable Easy Parallelism
        //How do we use Streams ?
        // Source , Intermediate operations & terminal operation
        List<Integer> nums = Arrays.asList(1,2,3,4,5,6);
        int count = 0;
        for(int num:nums){
            if(num%2==0) count++;
        }
        System.out.println(nums.stream().filter(num -> num % 2 == 0).count());
        //Creating Streams
//        1. from Collections
        List<Integer> list = Arrays.asList(1,2,3,4,5,6);
        Stream<Integer> stream = list.stream();
        //2. from Arrays
        String[] arr = {"Rahul","Kunal","Vipul"};
        Stream<String> stream1 = Arrays.stream(arr);
        //3.Using Stream.Of()
        Stream<String> name = Stream.of("Rahul", "Kunal", "Vipul");
        //4.infinite Stream
        List<Integer> generate = Stream.generate(()->1).limit(100).limit(10).collect(Collectors.toList());
        System.out.println(generate);
        List<Integer> numbers = Stream.iterate(1, num -> num + 1).limit(100).collect(Collectors.toList());
        System.out.println(numbers);
    }
}
