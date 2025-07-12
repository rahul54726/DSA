import java.util.Scanner;

public class ChessGame {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        String str=sc.next();
        int anton=0;
        int danik=0;
        for(int i =0;i<str.length();i++){
            if(str.charAt(i)=='A') anton++;
            else if(str.charAt(i)=='D') danik++;
        }
        if(anton>danik) System.out.println("Anton");
        else if(anton==danik) System.out.println("Friendship");
        else System.out.println("Danik");
    }
}
