package com.CollectionFrameWorks.HashMaps;
import java.util.*;
import java.util.Map;

public class HashTables {
    public static void main(String[] args) {

    }
    public List<String> letterCombinations(String digits) {
        List<String> result=new ArrayList<>();
        if(digits==null|| digits.length()==0){
            return result;
        }
        String[] phoneMap={"","","abc","def","ghi","jkl","mno","pqrs","tuv","wxyz"};
        backTracking(result,phoneMap,digits,new StringBuilder(),0);
        return result;

    }

    private void backTracking(List<String> result, String[] phoneMap, String digits, StringBuilder current,int index) {
        if(index==digits.length()){
            result.add(current.toString());
            return;
        }
        String letters=phoneMap[digits.charAt(index)-'0'];
        for (char letter:letters.toCharArray()){
            current.append(letter);
            backTracking(result,phoneMap,digits,current,index+1);
            current.deleteCharAt(current.length()-1);
        }
    }
}
