package com.CollectionFrameWorks.HashMaps;
import  java.util.*;
public class Map {
    public static void main(String[] args) {
//        HashMap<String,Double> map=new HashMap<>(3,0.5f);
//        map.put("Rahul",22.00);
//        map.put("Raj",21.00);
//        map.put("Priyanshu",20.00);
//        map.put("Rohit",19.00);
////        map.putAll(map);
//        System.out.println(map);
//        map.putIfAbsent("Rahul",22.00);
//        map.putIfAbsent("Nilay",23.00);
//        System.out.println(map);
//        System.out.println(map.isEmpty());
//        map.remove("Nilay");
//        System.out.println(map);
//        map.replace("Rohit",32.00);
//        System.out.println(map);
//        System.out.println(map.isEmpty());
//        System.out.println(map.size());
        HashMap<Character,String> lmap=new LinkedHashMap<>();
        lmap.put('a',"Monday");
        lmap.put('b',"Tuesday");
        lmap.put('c',"Wednesday");
        lmap.put('d',"Thursday");
        lmap.put('e',"Friday");
        lmap.put('f',"Saturday");
        lmap.put('g',"Sunday");
        System.out.println(lmap);
        System.out.println(lmap.get('c'));
        TreeMap<Integer,String> treeMap=new TreeMap<>();
        treeMap.put(1,"sunday");
        treeMap.put(2,"monday");
        treeMap.put(3,"wednesday");
        System.out.println(treeMap.descendingMap());
        if (treeMap.containsKey(2)) System.out.println("yes");
        System.out.println(treeMap);

//        System.out.println(lengthOfLongestSubstring("pwwkew"));
        int[] arr={1,0,0,0,1};
//        System.out.println(canPlaceFlowers(arr,2));


    }
    public static int lengthOfLongestSubstring(String s) {
        HashSet<Character> str=new HashSet<>();
        int left=0;
        int maxLength=0;
        for (int right =0;right<s.length();right++){
            while (str.contains(s.charAt(right))){
                str.remove(s.charAt(left));
                left++;
            }
            str.add(s.charAt(right));
            maxLength=Math.max(maxLength,right-left+1);
        }
        return maxLength;
    }
    public static boolean canPlaceFlowers(int[] flowerbed, int n) {
        int count=0;
        for (int i = 0;i<flowerbed.length;i++){
            if(flowerbed[i]==0){
                boolean emptyLeft = (i ==0 ) || (flowerbed[i-1]==0);
                boolean emptyRight = (i ==flowerbed.length-1 ) || (flowerbed[i+1]==0);
                if ( emptyLeft&&emptyRight  ){
                    flowerbed[i]=1;
                    count++;
                    if (count>=n){
                        return true;
                    }
                }

            }
        }
        return count>=n;
    }
    public boolean uniqueOccurrences(int[] arr) {
        Arrays.sort(arr);
        HashMap<Integer,Integer> hashMap=new HashMap<>();
        for(int n:arr){
            hashMap.put(n,hashMap.getOrDefault(n,0)+1);
        }
        HashSet<Integer> set=new HashSet<>(hashMap.values());
        return hashMap.size()==set.size();
    }
    public boolean closeStrings(String word1, String word2) {
//        char[] arr1=word1.toCharArray();
//        char[] arr2=word2.toCharArray();
//        Arrays.sort(arr2);
//        Arrays.sort(arr1);
//        boolean flag=true;
//        if (word1.length()!=word2.length()){
//            flag=false;
//        }
//        for (int i = 0;i<word1.length();i++){
//            if (arr1[i]!=arr2[i]) flag=false;
//        }
//        return flag;
        if (word1.length()!=word2.length()) return false;
        int[] freq1 =new int[26];
        int[] freq2 =new int[26];
        for(char c:word1.toCharArray()){
            freq1[c-'a']++;
        }
        for(char c:word2.toCharArray()){
            freq2[c-'a']++;
        }
        for (int i=0;i<26;i++){
            if ((freq1[i]==0 && freq2[i]>0) || (freq2[i]==0 && freq1[i]>0)){
                return false;
            }
        }
        Arrays.sort(freq1);
        Arrays.sort(freq2);
        return Arrays.equals(freq1,freq2);
    }

}
