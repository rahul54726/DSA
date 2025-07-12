package com.CollectionFrameWorks.HashMaps;

public class KarpRabin {
    private  final int prime=101;
    private long calculateHash(String str){
        long hashValue=0;
        for(int i=0;i<str.length();i++){
            hashValue= (long) (hashValue+str.charAt(i)*Math.pow(prime,i));
        }
        return hashValue;
    }
    private long updateHash(long pevHash,char oldChar,char newChar,int patternLength){
        long newHash=(pevHash-oldChar)/prime;
        newHash= (long) (newHash+newChar*Math.pow(prime,patternLength-1));
        return newHash;
    }
    public void search(String text,String pattern){
        int patternLength=pattern.length();
        long patternHash=calculateHash(pattern);
        long textHash=calculateHash(text.substring(0,patternLength));
        for (int i=0;i<=text.length()-patternLength;i++){
            if (textHash==patternHash){
                if(text.substring(i,i+patternLength).equals(pattern)){
                    System.out.println("Pattern found at index :" + i);
                }
            }
            if(i<text.length()-patternLength){
                textHash=updateHash(textHash,text.charAt(i),text.charAt(i+patternLength),patternLength);
            }
        }
    }
}
