import java.util.Scanner;

public final class LuckyNumber {
    public static long lenght(long n){
        int count =0;
        while(n!=0){
            n=n/10;
            count++;

        }
        return count;
    }
    
    public static void main(String args[]){
        Scanner sc=new Scanner(System.in);
        long   n=sc.nextLong();
        int count7=0;
        int count4=0;
        long len=lenght(n);
        if(n>10){
            for(int i=0;i<len;i++){
                if(n%10==7) count7++;
                else if(n%10==4) count4++;
                n/=10;
                
            }
        }
        int count =count4+count7;
        if(count==len) System.out.println("YES");
        else System.out.println("NO");

        
        
        
        
        
    }
}
