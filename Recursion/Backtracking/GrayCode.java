package com.Recursion.Backtracking;
import java.util.*;
public class GrayCode {
    public static void main(String[] args) {
//        System.out.println(grayCode(2));
//        int[][] points={{1,1},{2,2},{3,3},{4,4},{5,5},{7,4}};
//        System.out.println(maxPoints(points));
        System.out.println(climbStairs(4));

    }

    public static List<Integer> grayCode(int n) {
        int num=(int)Math.pow(2,n);
        List<Integer> list=new ArrayList<>();
        for(int i=0;i<num;i++){
            list.add(binaryToGray(i));
        }
        return list;
    }

    private static int binaryToGray(int num){
        return num ^ (num >> 1);
    }
    public static int maxPoints(int[][] points) {
        HashMap<Double,Integer> map=new HashMap<>();
        for (int i = 0;i<points.length;i++){
            for(int j = i+1; j<points.length;j++){
                Double slope = (double) ((points[j][1] - points[i][1])/(points[j][0] - points[i][0]));
                map.put(slope,map.getOrDefault(slope,0)+1);
            }
        }
        int max = Integer.MIN_VALUE;
        for(int value : map.values()){
            max=Math.max(value,max);
        }
        return max;
    }
    public static int climbStairs(int n) {
        if(n==0){
            return 1;
        }
        int count=0;
        for (int i = 1; i <= 2 && i<=n; i++) {
            count+=climbStairs(n-i);
        }
        return count;
    }
}
