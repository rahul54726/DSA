import java.util.*;
public class Mathematician {
    
    public static void main(String[] args) {
        Scanner sc= new Scanner(System.in);
       String a= sc.next();
       String b= sc.next();
       String sol="";
       for(int i = 0;i<a.length();i++){
        if(a.charAt(i)!=b.charAt(i)){
            sol+='1';
        }
        else{
            sol+='0';
        }
       }
       System.out.println(sol);

        
        
    }
}
