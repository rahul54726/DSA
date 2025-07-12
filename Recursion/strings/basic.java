package com.Recursion.strings;

public class basic {
    static String withouta(int ptr, String str, String ans){
        if(ptr ==str.length()){
            return ans;
        }
        while (ptr <str.length()){
            if(str.charAt(ptr)!='a')  return withouta(ptr +1,str,ans+str.charAt(ptr));
            else if(str.charAt(ptr)=='a') return withouta(ptr +1,str,ans);
        }
        return ans;
    }
    static void skip(String p,String up){
        if(up.isEmpty()){
            System.out.println(p);
            return ;
        }
        char ch=up.charAt(0);
        if(ch == 'a'){
            skip(p,up.substring(1));
        }
        else {
            skip(p+ch,up.substring(1));
        }
    }
    static String skip(String up){
        if(up.isEmpty()){
            return "";
        }
        char ch=up.charAt(0);
        if(ch=='a'){
            return skip(up.substring(1));
        }
        else {
            return ch+skip(up.substring(1));
        }
    }
    static String skipapple(String up){
        if(up.isEmpty()){
            return "";
        }

        if(up.startsWith("apple")){
            return skipapple(up.substring(5));
        }
        else {
            return  up.charAt(0)+skipapple(up.substring(1));
        }
    }

//    public static int strStr(String haystack, String needle) {
//
//        if (needle.isEmpty()){
//            return 0;
//        }
//        for (int i = 0; i <= haystack.length()-needle.length() ; i++) {
//            if (haystack.substring(i,i+needle.length()).equals(needle)){
//                return i;
//            }
//        }
//        return -1;
//    }
//    public boolean isSubsequence(String s, String t) {
////        int i=0,j=0;
////        while (i<s.length()&&j<t.length()){
////            if (s.charAt(i)==t.charAt(j)){
////                i++;
////            }
////            j++;
////        }
////        return i==s.length();
////        Map<Character, List<Integer>> charIndex=new HashMap<>();
////        for (int i = 0; i < t.length(); i++) {
////            charIndex.putIfAbsent(t.charAt(i),new ArrayList<>());
////            charIndex.get(t.charAt(i)).add(i);
////        }
////        int prevIndex=-1;
////        for(char c:s.toCharArray()){
////            if (!charIndex.containsKey(c)){
////                return false;
////            }
////            List<Integer> indecies=charIndex.get(c);
////            int idx= Collections.binarySearch(indecies,prevIndex+1);
////            if(idx<0){
////                idx=-idx-1;
////            }
////            if (idx==indecies.size()){
////                return false;
////            }
////            prevIndex=indecies.get(idx);
////        }
//        return true;
//        return help(s,t,0,0);
//    }
//
//    private boolean help(String s, String t, int i, int j) {
//        if (i==s.length()) return true;
//        if (j==t.length()) return false;
//        if (s.charAt(i)==t.charAt(j)){
//            return help(s,t,i+1,j+1);
//        }
//        return help(s,t,i,j+1);
//    }
//    public List<List<Integer>> findDifference(int[] nums1, int[] nums2) {
//        HashSet<Integer> set1 =new HashSet<>();
//        HashSet<Integer> set2 =new HashSet<>();
//        for (int i:nums1) {
//            set1.add(i);
//        }
//        for (int j:nums2) {
//            set2.add(j);
//        }
//        List<Integer> diff1=new ArrayList<>(set1);
//        diff1.removeAll(set2);
//
//        List<Integer> diff2=new ArrayList<>(set2);
//        diff2.removeAll(set1);
//
//        List<List<Integer>> result=new ArrayList<>();
//        result.add(diff1);
//        result.add(diff2);
//        return result;
//    }
    public static String skipApp(String up){
        if(up.isEmpty()){
            return "";
        }
        if(up.startsWith("apple")){
            return skipApp(up.substring(3));
        }
        else return up.charAt(0)+skipApp(up.substring(1));
    }

    public static void main(String[] args) {
        String up="bacd";
//        System.out.println(skipapple(up));
//        System.out.println(skipApp(up));
        System.out.println(skip(up));
    }
}
