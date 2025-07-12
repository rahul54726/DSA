import java.util.Scanner;

public class shoehorse {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        long arr[] = new long [4];
        int count=0;
        for(int i=0;i<4;i++){
            arr[i]=sc.nextLong();
        }
        for(int i=0;i<4;i++){
            for(int j=i+1;j<4;j++){
                if(arr[i] != arr[j]){
                    count++;
                }
            }
        }
        if (count==6) System.out.println(0);
        else if (count==5) System.out.println(1);
        else if (count==3) System.out.println(2);
        else if (count==0) System.out.println(3);
    }
}
