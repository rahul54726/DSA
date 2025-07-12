import java.util.*;
import java.lang.*;
import java.io.*;

class Codechef {
    public static void main(String[] args) throws java.lang.Exception {
        // your code goes here
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0) {
            int n = sc.nextInt();
            boolean flag=false;
            String word = sc.next();
            int count=0;
            if(n>=4){
                for (int i = 0; i < n-4; i++) {
                    // String sub = word.substring(i, i + 4);
                    // for (int j = 0; j < 4; j++) {
                    //     if (sub.charAt(j) != 'a'|| sub.charAt(j) != 'e' || sub.charAt(j) != 'i' || sub.charAt(j) != 'o'
                    //             || sub.charAt(j)!= 'u'){
                    //        count++;
                    //        break;
                           
                    //     }
                        
    
                    // }
                        if (word.charAt(i) != 'a'||word.charAt(i) != 'e' || word.charAt(i) != 'i' || word.charAt(i) != 'o'
                                || word.charAt(i)!= 'u'){
                           count++;
                           
                        }
                        if(count>=4) break;

                }
            }
           
            if(count>=4) flag=true;
            if(flag==true) System.out.println("No");
            else System.out.println("Yes");

        }

    }
}
