package com.BitManuplation;
import java.util.Scanner;
public class MagicNumber {
    static int magic(int n){
        int ans=0;
        int base=5;
        while (n>0){
            int last=n & 1;
            n=n>>1;
            ans += last * base;
            base=base*5;
        }
        return ans;
    }
    static int noOfBits(int n){
        if (n==0) return 0;
        return (int) (Math.log(n)/Math.log(2)+1);
    }
    static boolean isPowerOfTwo(int n){
        if (n==0)return false;
        return( n&(n-1)) ==0;
    }
    static int power(int base,int power){
        int ans=1;
        while (power>0){
            if((power&1)==1) ans*=base;
            base*=base;
            power>>=1;
        }
        return ans;
    }
   
    public static void main(String[] args) {
        Scanner in =new Scanner(System.in);
        int a=in.nextInt();
        System.out.println(magic(a));
        System.out.println(noOfBits(a));
        System.out.println(isPowerOfTwo(a));
        System.out.println(power(3,6));
        System.out.println(Integer.toBinaryString(a));
    }
//    public String multiply(String num1, String num2) {
//            if (num1=="0" && num2=="0") return "0";
//            int[] result=new int[num1.length()+num2.length()];
//            for(int i= num1.length()-1;i>=0;i--){
//                for (int j=num2.length()-1;j>=0;j--){
//                    int mul=(num1.charAt(i)-'0') * (num2.charAt(j)-'0');
//                    int sum=mul=result[i+j+1];
//                    result[i+j+1]=sum%10;
//                    result[i+j]=sum/10;
//                }
//            }
//            StringBuilder sb=new StringBuilder();
//            for (int num :result){
//                if(!(sb.length()==0 && num==0)){
//                    sb.append(num);
//                }
//            }
//            return sb.toString();
//    }
//
//    private static Integer tonum(String num1) {
//        int ans = 0;
//        while (!num1.isEmpty()) {
//            ans = ans * 10 + ((int) (num1.charAt(0)) - 48);
//
//            num1 = num1.substring(1);
//        }
//        return ans;
//
//    }
    public int[][] flipAndInvertImage(int[][] image) {
        for(int[] row:image){
            //reverse this array
            for (int i=0;i<(image[0].length + 1)/2;i++){
                // swap
                int temp=row[i] ^ 1;
                row[i]=row[image[0].length-i-1];
                row[image[0].length-i-1]=temp;
            }
        }
        return image;
    }
}
