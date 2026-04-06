package com.LeetCode.medium;

import java.util.Arrays;

public class DecodeCiphertext {
    public static String decodeCiphertext(String encodedText, int rows) {
        int encodedLength = encodedText.length();
        if (encodedLength == 0) return "";
        System.out.println(encodedLength);
        int cols = encodedLength / rows ;
        char[][] arr = new char[rows][cols];
        int count = 0;
        for(int i = 0;i < rows;i++){
            for(int j = 0;j < cols ; j++){
                arr[i][j] = encodedText.charAt(count);
                count++;
            }
        }
        for (char[] chars : arr) System.out.println(Arrays.toString(chars));

        StringBuilder sb = new StringBuilder();
        for (int col = 0;col < cols ; col++){
            int i = 0;
            int j = col;
            while(i < rows && j < cols){
                sb.append(arr[i++][j++]);
            }
        }
        while (sb.length() > 0 && sb.charAt(sb.length()-1) == ' '){
            sb.deleteCharAt(sb.length() - 1);
        }

        return sb.toString();
    }

    public static void main(String[] args) {
        System.out.println(decodeCiphertext("iveo    eed   l te   olc" , 4));
    }
}
