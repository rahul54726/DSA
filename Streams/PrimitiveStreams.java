package com.Streams;

import java.util.Arrays;
import java.util.Random;
import java.util.stream.Collectors;
import java.util.stream.DoubleStream;
import java.util.stream.IntStream;

public class PrimitiveStreams {
    public static void main(String[] args) {
        int[] numbers = {1,2,3,4,5,6};
        IntStream stream = Arrays.stream(numbers);
        IntStream range = IntStream.range(1,5);
        System.out.println(range.boxed().collect(Collectors.toList()));
        System.out.println(IntStream.rangeClosed(1,5).boxed().collect(Collectors.toList()));
        DoubleStream doubleStream = new Random().doubles(5);
        System.out.println(doubleStream.boxed().toList());
//        System.out.println(doubleStream.sum());
        IntStream stream1 = new Random().ints(5);
        System.out.println(stream1.boxed().toList());
//        System.out.println(stream1.sum());
    }
}
