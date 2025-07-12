package com.CollectionFrameWorks.HashMaps;
import java.util.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

//HASHMAPS are not Thread safe
public class HashMapp {
    public static void main(String[] args) {
        HashMap<Integer,Character> alphabets=new HashMap<>();
        for (int i=1;i<=26;i++){
            char ch= (char) (96+i);
            alphabets.put(i,ch);
        }
//        System.out.println(alphabets);
//        System.out.println(alphabets.containsKey(25));
//        System.out.println(alphabets.containsValue('z'));
//        System.out.println(alphabets.getOrDefault(27,'5'));
//        int[] nums={4,5,6,7,4,5,8,9};
//        System.out.println(freqCount(nums));
//        System.out.println(duplicates(nums));
//        String one="luhar";
//        String two="rahul";
//        System.out.println(isAnagram(one,two));
//        String str="szwiss";
//        System.out.println(firstNonRepeating(str));
//        int[] arr={1,2,3};
//        System.out.println(subArray(arr,3));
//        int[] a={4,9,5};
//        int[] b={9,4,9,8,4};
//        System.out.println(intersection(a,b));
        int[] nums={1,1,1,2,2,3};
        System.out.println(Arrays.toString(topKFrequent(nums,2)));
    }
//Frequency count//
    public static HashMap<Integer,Integer> freqCount(int[] nums){
        HashMap<Integer,Integer> result=new HashMap<>();
        for (int num:nums){
            result.put(num,result.getOrDefault(num,0)+1);
        }
        return result;
    }
    //Find duplicates in an array
    public static ArrayList<Integer> duplicates(int[] nums){
        HashMap<Integer,Integer> map=new HashMap<>();
        for (int num:nums){
            map.put(num,map.getOrDefault(num,0)+1);
        }
        ArrayList<Integer> list=new ArrayList<>();
        for (int key:map.keySet()){
            if(map.get(key)>1) list.add(key);
        }
        return list;
    }
    public static boolean isAnagram(String one,String two){
        if(one.length()!=two.length()) return false;
        HashMap<Character,Integer> map=new HashMap<>();
        for (char ch:one.toCharArray()){
            map.put(ch,map.getOrDefault(ch,0)+1);
        }
        for (char ch:two.toCharArray()){
            if (!map.containsKey(ch)||map.get(ch)==0) return false;
            map.put(ch,map.get(ch)-1);
        }
//        for (char key:map.keySet()){
//            if (map.get(key)!=0) return false;
//        }
        return true;
    }
    public static char firstNonRepeating(String str){
        HashMap<Character,Integer> map=new HashMap<>();
        for (char ch:str.toCharArray()){
            map.put(ch,map.getOrDefault(ch,0)+1);
        }
        for (char ch:str.toCharArray()){
            if(map.get(ch)==1) return ch;
        }
        return ' ';
    }
    public static int subArray(int[] nums,int k){
        HashMap<Integer,Integer> sumMap=new HashMap<>();
        sumMap.put(0,1);
        int cumulativeSum=0;
        int count=0;
        for (int num:nums){
            cumulativeSum+=num;
            if(sumMap.containsKey(cumulativeSum-k)){
                count+=sumMap.get(cumulativeSum-k);
            }
        sumMap.put(cumulativeSum,sumMap.getOrDefault(cumulativeSum,0)+1);
        }
        return count;
    }
    public int[] twoSum(int[] nums, int target) throws IllegalAccessException {
        HashMap<Integer,Integer> map=new HashMap<>();
        for (int i=0;i<nums.length;i++){
            int num=nums[i];
            if(map.containsKey(target-num)){
                return new int[]{map.get(target-num),i};
            }
            map.put(nums[i],i);
        }
        throw new IllegalAccessException("no two sum solution");
    }
    public static int[] intersection(int[] nums1, int[] nums2) {
        HashMap<Integer,Integer> map1=new HashMap<>();
        HashMap<Integer,Integer> map2=new HashMap<>();
        ArrayList<Integer> list=new ArrayList<>() ;
        for(int num:nums1){
            map1.put(num, map1.getOrDefault(num,0)+1);
        }for(int num:nums2){
            map2.put(num, map2.getOrDefault(num,0)+1);
        }

        for(int key:map1.keySet()){
            if (map2.containsKey(key)){
                list.add(key);

            }
        }
        int[] arr=new int[list.size()];
        for (int i=0;i<list.size();i++){
            arr[i]=list.get(i);
        }
        return arr;
    }
//    public List<List<String>> groupAnagrams(String[] strs) {
//        if (strs == null || strs.length == 0) {
//            return new ArrayList<>();
//        }
//        Map<String, List<String>> map = new HashMap<>();
//
//        for (String str : strs) {
//            // Sort the string to create the key
//            char[] charArray = str.toCharArray();
//            Arrays.sort(charArray);
//            String sortedKey = new String(charArray);
//
//            // Add the string to the corresponding group
//            map.putIfAbsent(sortedKey, new ArrayList<>());
//            map.get(sortedKey).add(str);
//        }
//
//        // Return all grouped anagrams
//        return new ArrayList<>(map.values());
//    }
    public static int[] topKFrequent(int[] nums, int k) {
        HashMap<Integer,Integer> map=new HashMap<>();
        for(int num:nums){
            map.put(num,map.getOrDefault(num,0)+1);
        }
        PriorityQueue<HashMap.Entry<Integer,Integer>> minheap=new PriorityQueue<>((a,b) -> a.getValue()-b.getValue());
        for(Map.Entry<Integer,Integer> entry:map.entrySet()){
            minheap.offer(entry);
            if(minheap.size()>k){
                minheap.poll();
            }
        }
        int[] result=new int[k];
        int index=0;
        while (!minheap.isEmpty()){
             result[index++]=minheap.poll().getKey();
        }
        return result;
    }
}

