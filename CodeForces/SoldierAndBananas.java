import java.util.*;
public final class SoldierAndBananas {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int k=sc.nextInt();
        int n=sc.nextInt();
        int w=sc.nextInt();
        int money =0;
        for(int i=1;i<=w;i++){
            money+=k*i;
        }
        if(money<=n) System.out.println(0);
        else System.out.println(money-n);
        
    }
    
}
