import java.util.*; 
public class Drinks {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        double arr[] = new double[n];
        for(int i=0;i<n;i++){
            arr[i]=sc.nextDouble();
        }
        double count =0;
        for(int i=0;i<n;i++){
            count +=arr[i];
        }
        double op=count/n;
        System.out.println(op);

        
    }
}
