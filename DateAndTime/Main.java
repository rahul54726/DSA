package com.DateAndTime;

import java.time.LocalDate;
import java.time.LocalTime;

public class Main {
    public static void main(String[] args) {
        LocalDate date=LocalDate.now();
        LocalTime time=LocalTime.now();
        System.out.println( "Date is : "+date+ "\nAnd Current time is : " +time );
    }
}
