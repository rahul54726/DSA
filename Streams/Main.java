package com.Streams;

import java.util.Arrays;
import java.util.List;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        //predicate used for check a condition is true or false or we can say that it holds a condition
//        predicate is a functional Interface
        Predicate<Integer> predicate = x -> x%2 == 0;
        System.out.println(predicate.test(8));
        Predicate<String> isStartWitha = x -> x.startsWith("a");
        System.out.println(isStartWitha.test("xyz"));
        //Function --> work for us
        Function<Integer , Integer> doubleIt = x -> 2 * x;
        Function<Integer,Integer> tripleIt = x -> 3 * x;
        System.out.println(doubleIt.andThen(tripleIt).apply(100));
        System.out.println(doubleIt.compose(tripleIt).apply(12));

        //Methode Reference --> use methode invoking & in place of lambda Expression
        List<String> boys = Arrays.asList("Rahul", "Kunal", "Vipul");
        boys.forEach(item-> System.out.println(item));
        boys.forEach(System.out::println);

        //constructor Reference
        List<String> names = Arrays.asList("Samsung" ,"IPhone","Vivo","Oppo","Redmi");
//        List<MobilePhone> collect = names.stream().map(phone -> new MobilePhone(phone)).collect(Collectors.toList());
        List<MobilePhone> collect = names.stream().map(MobilePhone::new).toList();
    }
}
class MobilePhone{
    String name;

    public MobilePhone(String name) {
        this.name = name;
    }
}
