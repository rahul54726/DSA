package com.LeetCode.days75;
import java.util.*;

public class ContainerWithMostWater {
    public int maxArea(int[] height) {
        int start=0;
        int end=height.length-1;
        int maxAreaa=0;
        while (start<end){
            int width=end-start;
            int currentHt=Math.min(height[start],height[end]);
            int currentArea=width*currentHt;
            maxAreaa=Math.max(maxAreaa,currentArea);
            if(height[start] < height[end]){
                start++;
            } else{
                end--;
            }
        }

        return maxAreaa;
    }
}
