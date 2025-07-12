package com.LeetCode.Easy;

import java.util.Scanner;

public class lengthoflastword {
    public static int lengthOfLastWord(String s) {
        int end = s.length() - 1;

        while (end >= 0 && s.charAt(end) == ' ') {
            end--;
        }

        int start = end;
        while (start >= 0 && s.charAt(start) != ' ') {
            start--;
        }

        return end - start;

    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String s=in.nextLine();
        System.out.println(lengthOfLastWord(s));
    }
}
