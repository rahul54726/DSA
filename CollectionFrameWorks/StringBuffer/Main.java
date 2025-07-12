package com.CollectionFrameWorks.StringBuffer;

public class Main {
    public static void main(String[] args) {
        StringBuffer buffer=new StringBuffer();
        buffer.append("WeMakeDevs");
        String str=buffer.toString();
        System.out.print(buffer);
        buffer.replace(1,1,"a");
        System.out.println(buffer);
    }
}
