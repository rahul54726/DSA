import  java.util.*;
public class BeautifulYear {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int year = sc.nextInt();
        int count =year;
        
        for(int i =0;i<4;i++){
            String yr=String.valueOf(year);
            for(int j = i+1;j<4-i;j++){
                if(yr.charAt(i)==yr.charAt(j)){
                    count++;
                }
                else break;
                
            }year=count;
        }
        System.out.println(year);
        
            
           

    }
}
