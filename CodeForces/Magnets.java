import java.util.*;
public class Magnets {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        int count =0;
        int arr[]= new int[n]; 
        if(n==1) count++;
        else{
            {
                for(int i=0;i<n;i++){
                    arr[i]=sc.nextInt();
                }
                for(int i=0;i<n-1;i++){
                   
                    if((arr[i]==10 && arr[i+1]==10)||(arr[i]==01 && arr[i+1]==01) ) count++;
                }
            }
        }

        System.out.println(count);
    }
}
