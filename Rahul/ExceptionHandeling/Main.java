package com.Rajpoot.ExceptionHandeling;

public class Main {
    public static void main(String[] args) throws Exception{
        int a=5;
        int b=0;
        try{
            int c=a/b;
        }catch (Exception e){
            System.out.println(e.getMessage());
        }finally {
            System.out.println("This will always execute");
        }
        System.out.println(divide(a,b));
    }
    static int divide(int a,int b) throws Exception{
        if(b==0) {
            throw new Exception("We cannot divide by ZERO");
        }
        return a/b;
    }
}
