package com.LeetCode.TWOPOINTER;

public class MxPointsFromCards {
    public static void main(String[] args) {

    }
    static int maxPoints(int[] cards,int k){
        int right = cards.length - 1;
        int leftSum = 0;
        for(int i = 0;i<k;i++){
            leftSum +=cards[i];
        }
        int maxSum = leftSum;
        int rightSum = 0;
        for (int i = k-1;i>=0;i--){
            leftSum = leftSum - cards[i];
            rightSum = rightSum+cards[right--];
            maxSum = Math.max(maxSum,leftSum+rightSum);
        }
        return maxSum;
    }

}
