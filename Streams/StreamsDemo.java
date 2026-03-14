package com.Streams;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.function.BiPredicate;
import java.util.function.Predicate;
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
        Predicate<Integer> isPowerOfTwo = (x) -> {
                                if(x== 0) return false;
                                return (x & (x - 1)) == 0;
        };
        List<Integer> list1 = Arrays.asList(2, 4, 8, 9, 25,1024);
        List<Integer> list2 = list1.stream().filter(isPowerOfTwo::test).toList();
        int count1 = Math.toIntExact(list1.stream().filter(isPowerOfTwo::test).count());
        System.out.println(count1);
        System.out.println(list2);
        System.out.println(isPowerOfTwo.test(0));

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
        System.out.println(myAtoi(" 1337c0d3"));
    }
    public int minimumPairRemoval(int[] nums) {
        LinkedList<Integer> list = new LinkedList<>();
        for (int num : nums) list.add(num);
        int count = 0;
        while (!isSorted(list)){
            int[] temp = new int[list.size() - 1];
            for (int i = 0;i<temp.length;i++){
                temp[i] = list.get(i)+list.get(i + 1);
            }
            int minIndex = -1;
            for(int i = 1;i<temp.length;i++){
                if(temp[i] < temp[i - 1]){
                    minIndex = i;
                }
            }
            list.remove(minIndex + 1);
            list.remove(minIndex );
            list.add(minIndex,temp[minIndex]);
            count++;
        }
        return count;

    }

    private boolean isSorted(LinkedList<Integer> list) {
        int prev = list.get(0);
        for(int i = 1;i<list.size();i++){
            if(prev > list.get(i)) return false;
        }
        return true;
    }
    public static int myAtoi(String s) {
        int ans = 0;
        if (s.charAt(0) >='a' && s.charAt(0) <= 'z') return 0;
        if (s.charAt(0) >='A' && s.charAt(0) <= 'Z') return 0;
        while (s.startsWith(" ")){
            s = s.substring(1);
        }
        char ch = s.charAt(0);
        if(ch == '-') s = s.substring(1);
        StringBuilder ansStr = new StringBuilder();
        for(int i = 0;i<s.length();i++){
            if(!(s.charAt(i) >= '0' && s.charAt(i) <= '9')) break;
            ansStr.append(s.charAt(i));
        }
        ans = Integer.parseInt(ansStr.toString());
        return ch == '-' ? ans * -1 : ans ;
    }
    public int lengthOfLIS(int[] nums) {
        int n = nums.length;
        
        return 0;
    }
}
