import java.util.*;
public final class Fence {
    public static void main(String[] args) {
        Scanner sc =new Scanner(System.in);
        int n = sc.nextInt();
        int h = sc.nextInt();
        int arr[] = new int[n];
        for(int i=0;i<n;i++){
            arr[i]=sc.nextInt();
        }
        int count =0;
        for(int i=0;i<n;i++){
            if(arr[i]>h){
                count+=2;
            }
            else count++;
        }
        System.out.println(count);
        
    }

}
