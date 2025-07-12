package com.AgeCalculator;

import java.time.LocalDate;
import java.time.Period;
import java.util.Scanner;

public class AgeCalc {
    public static int days(int DD,int MM,int YYYY ){
        LocalDate year=LocalDate.of(YYYY,MM,DD);
        LocalDate now= LocalDate.now();
        int dayFromStartYear=now.getDayOfYear();
        int years = now.getYear();
        int ans = dayFromStartYear;
        for(int i = YYYY+1;i<years;i++){
            if(isLeapYear(i)) ans+=366;
            else ans += 365;
        }
        if(isLeapYear(YYYY)){
            ans+=366-year.getDayOfYear();
        }
        else {
            ans += 365-year.getDayOfYear();
        }
        return ans;
    }
    private static boolean isLeapYear(int year){
        if(year % 4 == 0) return true;
        return false;
    }
//    public static int hours(int DD,int MM,int YYYY){
//        return days(DD,MM,YYYY)*24;
//    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.println("Enter your birth Year (YYYY) : ");
        int year = in.nextInt();
        System.out.println("Enter your birth Month (MM) : ");
        int month = in.nextInt();
        System.out.println("Enter your birth Day (DD) : ");
        int day = in.nextInt();
        LocalDate birthDate = LocalDate.of(year,month,day);
        LocalDate currentDate = LocalDate.now();
        Period age =Period.between(birthDate,currentDate);
        if(!birthDate.isAfter(currentDate)){
            System.out.println("Your age is : "+age.getYears() + " Years , "+age.getMonths()+" Months , "+age.getDays()+ " Days.");
        }
        else {
            System.out.println("You entered the date from future");
        }
    }
}
