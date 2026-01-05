package com.Streams;

import java.util.*;
import java.util.stream.Collectors;

public class CollectorsDemo {
    public static void main(String[] args) {
//        collectors is a utility class
//         collectors provides a set of methods to create common collectors
        List<String> names = List.of("Rahul","Kunal","Vipul","Raj","Raju","Priyanshu");
        List<String> list = names.stream().filter(name -> name.startsWith("R")).collect(Collectors.toList());
        System.out.println(list);
        String concatenatedNames = names.stream().map(String::toUpperCase).collect(Collectors.joining(", "));
        System.out.println(concatenatedNames);
        List<Integer> nums = Arrays.asList(2,3,5,7,11,15);
        IntSummaryStatistics stats = nums.stream().collect(Collectors.summarizingInt(x -> x));
        System.out.println("count : " + stats.getCount());
        System.out.println("Sum : " + stats.getSum());
        System.out.println("Min : " + stats.getMin());
        System.out.println("Average : " + stats.getAverage());
        System.out.println("Max : " + stats.getMax());
        Double average = nums.stream().collect(Collectors.averagingInt(x ->x));
        System.out.println(average);
        System.out.println(names.stream().collect(Collectors.groupingBy(String::length)));
        System.out.println(names.stream().collect(Collectors.groupingBy(String::length,Collectors.joining(" , "))));
        System.out.println(names.stream().collect(Collectors.groupingBy(String::length,Collectors.counting())));
        TreeMap<Integer, Long> treeMap = names.stream().collect(Collectors.groupingBy(String::length, TreeMap::new, Collectors.counting()));
        System.out.println(treeMap);
//        partitioning elements : partitions elements into two groups (true and false ) based on predicate
        System.out.println(names.stream().collect(Collectors.partitioningBy(x ->x.length() <= 5)));
    }
    public List<String> validateCoupons(String[] code, String[] businessLine, boolean[] isActive) {
        List<String> ans = new ArrayList<>();
        Map<String,Integer> priority = Map.of("electronics",0,
                "grocery",1,
                "pharmacy",2,
                "restaurant",3);
        List<int[]> valid = new ArrayList<>();
        for (int i = 0;i<code.length;i++){
            boolean isValidCode = code[i]!=null &&
                    !code[i].isEmpty() &&
                    code[i].matches("^[a-zA-Z0-9_]+$");

            if(isValidCode &&
                    priority.containsKey(businessLine[i]) &&
                    isActive[i]) {
                valid.add(new int[]{i});
            }
        }
        valid.sort((a,b)->{
            int p1 = priority.get(businessLine[a[0]]);
            int p2 = priority.get(businessLine[b[0]]);
            if(p1 != p2) return p1 - p2;
            return code[a[0]].compareTo(code[b[0]]);
        });
        for (int[]v : valid){
            ans.add(code[v[0]]);
        }
        return ans;
    }
}
