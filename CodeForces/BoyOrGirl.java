import java.util.*;

public class BoyOrGirl {
    public static void main(String arg[]) {
        Scanner sc = new Scanner(System.in);
        String bog = sc.next();
        int unique = 0;
        int arr[]=new int[26];
        for(int i=0;i<bog.length();i++){
         arr[bog.charAt(i)-97]++;
        }
        for(int i= 0 ; i<26;i++){
            if(arr[i]!=0) unique++;
        }
        if (unique>= 2 && unique % 2 == 0) {
            System.out.println("CHAT WITH HER!");
        } else if( unique==0) {
            System.out.println("CHAT WITH HER!");

        }
        else System.out.println("IGNORE HIM!");
       

    }

}
