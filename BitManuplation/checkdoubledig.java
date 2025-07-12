package com.BitManuplation;

public class checkdoubledig {
    public static void main(String[] args) {
        int[] arr={1,1,2,2,4,4,6};
        int bit=arr[0];
        for(int i=1;i<arr.length;i++){
            bit^=arr[i];
        }
        if(bit==0){
            System.out.println("True");
        }
        else System.out.println(bit);
    }
}
