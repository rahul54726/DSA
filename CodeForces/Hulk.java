import java.util.*;
public class Hulk {
    public static void im(int n){
        if(n==0){
           
            return;
        }
         System.out.println("I hate that I love that I hate it");
        im(n-1);
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n= sc.nextInt();
        if(n==1) System.out.println("I hate it");
       else if(n==2) System.out.println("I hate that I love it");
       else if(n>=3) im(n);
    }
    
}
