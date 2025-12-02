package com.LeetCode.Easy;

public class HasSameDigits {
    public boolean hasSameDigits(String s) {
        if (s.length() < 2) return false;
        if(s.length() == 2 && s.charAt(0) == s.charAt(1)) return  true;
        StringBuilder sb = new StringBuilder();
            for (int i = 0;i<s.length()-1;i++){
                int num1 = s.charAt(i) - '0';
                int num2 = s.charAt(i+1) - '0';
                sb.append((num1+num2)%10);
            }
            s = sb.toString();

        return hasSameDigits(s);
    }
}
