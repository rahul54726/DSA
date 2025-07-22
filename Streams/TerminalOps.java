package com.Streams;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class TerminalOps {
    public static void main(String[] args) {
        List<Integer> nums = Arrays.asList(1,2,3,4,5,6);
        //1. collectors
        List<Integer> num = nums.stream().skip(1).collect(Collectors.toList());
        List<Integer> num1 = nums.stream().skip(1).toList();
        System.out.println(num);
//        2.forEach
        nums.stream().forEach(x -> System.out.print(x*x + " "));
//        3.reduces
        Optional<Integer> optionalInteger = nums.stream().reduce(Integer::sum);
        System.out.println(optionalInteger.get());
//        4.count
//        5.allMatch,noneMatch,anyMatch
        boolean b = nums.stream().allMatch(x -> x % 2 == 0);
//        6.findFIrst,findany
        System.out.println(nums.stream().findFirst().get());
        System.out.println(nums.stream().findAny().get());
//      7.toArray
        Stream.of(1,2,3).toArray();
//        8.min max
        System.out.println( "max : " + Stream.of(1,2,3,44).max(Comparator.naturalOrder()));
        System.out.println( "max : " + Stream.of(1,2,3,44).max((o1,o2) -> o1 -o2));

        List<Integer> list = Arrays.asList(5,6,4,8,7,9);
        List<Integer> list1 = list.stream().map(x -> x * x).sorted().toList();
        System.out.println(list1);
        //summing values
        System.out.println(list.stream().reduce(Integer::sum).get());
        // counting
        String sentence = "HelloWorld";
        long count = sentence.chars().filter(x -> x == 'l').count();
        System.out.println(count);
        

    }
}
