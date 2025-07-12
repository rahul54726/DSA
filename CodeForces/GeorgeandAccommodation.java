import java.util.*;
public class GeorgeandAccommodation {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int n = sc.nextInt();
    int arr[][]=new int[n][2];
    int count =0;
    for(int i=0;i<n;i++){
        for(int j=0;j<2;j++){
            arr[i][j]=sc.nextInt();

        }
    }
    for(int i=0;i<n;i++){
        if(arr[i][1]-arr[i][0]>=2) count++;
    }
    System.out.println(count);
    
  }  
}
