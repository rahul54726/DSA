package com.Recursion.strings;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
public class Subset {
    static List<List<Integer>> subset(int[] nums){
        List<List<Integer>> outer=new ArrayList<>();
        outer.add(new ArrayList<>());
        for (int num:nums){
            int n = outer.size();
            for (int i = 0; i < n; i++) {
                List<Integer> inner=new ArrayList<>(outer.get(i));
                inner.add(num);
                outer.add(inner);
            }
        }
        return  outer;
    }
    static List<List<Integer>> subsetDuplicate(int[] nums){
        Arrays.sort(nums);
        List<List<Integer>> outer=new ArrayList<>();
        outer.add(new ArrayList<>());
        int start;
        int end=0;
        for (int i = 0; i< nums.length; i++){
            start=0;
            if(i>0&& nums[i]== nums[i-1]){
                start=end+1;
            }
            end= outer.size()-1;
            int n=outer.size();
            for (int j = start; j < n; j++) {
                List<Integer> inner=new ArrayList<>(outer.get(j));
                inner.add(nums[i]);
               outer.add(inner);
            }
        }
        return  outer;
    }
    public  static List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(nums); // Step 1: Sort the array

        for (int i = 0; i < nums.length - 2; i++) {
            // Skip duplicates for the first number
            if (i > 0 && nums[i] == nums[i - 1]) continue;

            int left = i + 1; // Step 2: Two pointers
            int right = nums.length - 1;
            int target = -nums[i];

            while (left < right) {
                int sum = nums[left] + nums[right];

                if (sum == target) {
                    // Found a triplet
                    result.add(Arrays.asList(nums[i], nums[left], nums[right]));

                    // Skip duplicates for the second and third numbers
                    while (left < right && nums[left] == nums[left + 1]) left++;
                    while (left < right && nums[right] == nums[right - 1]) right--;

                    // Move pointers
                    left++;
                    right--;
                } else if (sum < target) {
                    left++;
                } else {
                    right--;
                }
            }
        }
        return result;
    }

    public static void main(String[] args) {
        int[] arr={1,2,2};
        int[] arr2={0,0,0,0};
//        System.out.println(subset(arr2));
        System.out.println(subsetDuplicate(arr));
//        System.out.println(threeSum(arr2));
    }
}
