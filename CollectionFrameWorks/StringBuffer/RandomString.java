package com.CollectionFrameWorks.StringBuffer;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;

public class RandomString {
    public static String randomString(int length){
        StringBuffer sb=new StringBuffer(length);
        Random random=new Random();
        for (int i=0;i<length;i++){
            char randomChar = (char) (96 + (int) (random.nextFloat() * 26 ));
            sb.append(randomChar);
        }
        return sb.toString();
    }
    public static int randomNumber(int len){
        int count=0;
        Random random = new Random();
        while(len-->0){
            count += count *10 + (int)(random.nextFloat()*85);

        }

        return count;
    }
    public static void main(String[] args) {
        System.out.println(randomString(5));
        String sentence="R  a  h u l  R  a j  p u t";
        System.out.println(sentence);
        System.out.println(sentence.replaceAll("\\s","").toLowerCase());
        String names="Rahul Raj Priyanshu Rohit";
        String [] namesArr=names.split("\\s");
        System.out.println(Arrays.toString(namesArr));
        System.out.println(randomNumber(1));
        ArrayList<Integer> list = new ArrayList<>();
        for(int i =0;i<10;i++) list.add(i);
        String str = list.toString().replace(",","").replaceAll(" ","").replaceAll("]","").substring(1);
        System.out.println(str);
    }
}
