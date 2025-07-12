package com.LeetCode.Easy;

public class Ceilingchar {
    static char nextGreatestLetter(char[] letters,char target){
        if(target>=letters[letters.length-1]){
            return letters[0];
        }
        int start=0;
        int end=letters.length-1;
        while (start<=end){
            int mid=start+(end-start)/2;
            if (letters[mid]>target) {
                end=mid-1;
            }
            else start=mid+1;
        }
        return letters[start%letters.length];
    }

    public static void main(String[] args) {
        char[] letters={'e','e','e','e','e','e','n','n','n','n','x'};
        System.out.println(nextGreatestLetter(letters,'e'));

    }
}
