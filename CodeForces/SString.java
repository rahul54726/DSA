import java.util.Scanner;
import java.util.*;

public class SString {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.next();
        StringBuilder str1 = new StringBuilder(str);
        for(int i=1;i<str1.length();i++){
            str1.delete(i,i+1);
        }
        System.out.println(str1);
        int arr[]=new int[str1.length()];
        for(int i=0;i<str.length();i++){
            arr[i] = str.charAt(i);
        }
        Arrays.sort(arr);
        System.out.println(Arrays.toString(arr));
        
        
    }
    
}
