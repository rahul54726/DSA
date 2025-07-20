package com.LeetCode.medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class RemoveSubfolders {
    public static List<String> removeSubfolders(String[] folder) {
        Arrays.sort(folder);
        System.out.println(Arrays.toString(folder));
        List<String> result = new ArrayList<>();
        result.add(folder[0]);
        for(int i = 1;i<folder.length;i++){
            String sub = folder[i];
            String last = result.getLast();
            last+='/';
            if(sub.indexOf(last) !=0 ){
                result.add(sub);
            }
        }
        System.out.println(result);
        return result;
    }


    public static void main(String[] args) {
        removeSubfolders(new String[]{"/c","/d/c/e"});
    }
}
