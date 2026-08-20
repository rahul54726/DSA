package com;
class Solution {
    public static int maxNumberOfBalloons(String text) {
        int b = 0;
        int a = 0;
        int l = 0;
        int o = 0;
        int n = 0;
        for(char ch : text.toCharArray()){
            if(ch == 'b') b++;
            else if(ch == 'a') a++;
            else if(ch == 'l') l++;
            else if(ch == 'o') o++;
            else if(ch == 'n') n++;

        }

        int max = 0;
        for(int i = 1;i <= b;i++){
            if((l == 2 * i) && (o == 2 * i)){
                max = Math.max(i , max);
            }
        }
        return max;
    }

    public static void main(String[] args) {
        System.out.println(maxNumberOfBalloons("balllllllllllloooooooooon"));
    }
}
