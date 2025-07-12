package com.Streams;

import java.util.function.Predicate;

public class Main {
    public static void main(String[] args) {
        Predicate<Integer> predicate = x -> x%2 == 0;
        System.out.println(predicate.test(8));
        Predicate<String> isStartWitha = x -> x.startsWith("a");
        System.out.println(isStartWitha.test("xyz"));
    }
}
