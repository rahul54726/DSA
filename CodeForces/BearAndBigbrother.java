import java.util.*;;

public class BearAndBigbrother {
    
    public static void main(String[] args) {
        Scanner sc= new Scanner(System.in);
       double a=sc.nextDouble();
       double b=sc.nextDouble();
        int count =0;
        for(int i=0;i<10;i++){
            double aa = Math.pow(3, i);
            double bb = Math.pow(2, i);
            if(aa*a<=bb*b){
                count++;
            }
        }
        System.out.println(count);
        
    
        
    }
}
