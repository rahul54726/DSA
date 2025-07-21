package com.Streams;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class IntermediateOps {
    public static void main(String[] args) {
        //Intermediate ops transform a stream into another stream
        //They are lazy , means they don't execute until terminal Operation is Invoked.
        //1.filter
        List<String> names = Arrays.asList("Rahul","Kunal","Vipul","Rajul");
        Stream<String> filteredStream = names.stream().filter(name -> name.startsWith("R"));
        //no filtering at this point
        List<String> collect = filteredStream.collect(Collectors.toList());
//        2.map
        Stream<String> upperStream = names.stream().map(String::toUpperCase);
        List<String> collect1 = upperStream.collect(Collectors.toList());
//        3.sorted
        Stream<String> sorted = names.stream().sorted();
        Stream<String> sortedStreamUsingComparator = names.stream().sorted((a,b) -> (a.length() - b.length()));


    }
}
