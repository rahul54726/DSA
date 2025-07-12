package com.DSAMaths;

public class MultiplyString {
    public static void main(String[] args) {
        String str="123";
        System.out.println(integerToString(str));
        System.out.println(multiply("12","20"));

    }
    public static String multiply(String num1, String num2) {
        if(num1 == "0"   || num2 == "0") return "0";
        int n1=integerToString(num1);
        int n2=integerToString(num2);
        int mul= n1 * n2 ;
        return numToString(mul);

    }
    private static int integerToString(String str){
        int num=0;
        while (!str.isEmpty()){
            num=num*10 + (str.charAt(0)-'0');
            str = str.substring(1);
        }
        return num;
    }
    private static String numToString(int num){
        int temp=num;
        int rev=0;
        while (temp>0){
            rev = rev * 10+temp % 10;
            temp/=10;
        }
        String s="";
        while (rev!=0){
            s+=rev%10;
            rev/=10;
        }
        return s;
    }
}
