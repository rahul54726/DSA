import java.util.*;
public class Guy {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int x[]=new int[n];
        boolean flag=false;
        for(int i=0;i<n;i++){
            x[i]=sc.nextInt();
        }
        int y[]=new int[n];
        for(int i=0;i<n;i++){
            y[i]=sc.nextInt();
        }
        for(int i=0;i<n;i++){
            if(x[i]>=n)
            flag=true;
        }
        for(int i=0;i<n;i++){
            if(y[i]>=n)
            flag=true;
        }
        if(flag==true) System.out.println( "I become the guy.");
        else System.out.println("Oh, my keyboard!");

    }
}
