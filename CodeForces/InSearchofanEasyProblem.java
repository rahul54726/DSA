import java.util.*;
public class InSearchofanEasyProblem {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n=sc.nextInt();
        int arr[]=new int[n];
        int count =0;
        for(int i=0;i<n;i++){
            arr[i]=sc.nextInt();

        }
        for(int i=0;i<n;i++){
            if(arr[i]>0) count++;

        }
        if(count>0) System.out.println("HARD");
        else System.out.println("EASY");

    }
    
}
