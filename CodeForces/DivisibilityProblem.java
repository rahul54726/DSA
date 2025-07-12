import java.util.*;
public class DivisibilityProblem {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while(t-->0){
            int a= sc.nextInt();
            int b= sc.nextInt();
            int count =0;
            if(a>b && a%b!=0){
             int rem = a%b;
                count=b-rem; 
            }
            else if((a>b && a%b==0 ) || a==b) count =0;
            else if(a<b) count = b-a;
            System.out.println(count);
        }
    }
}
