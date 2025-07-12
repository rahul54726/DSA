import java.util.*;;
public final class Wordcapital {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        String word=sc.next();
        StringBuilder sb=new StringBuilder(word);
        char result;
          int a=0;
           a = (int)word.charAt(0);
           if(a>=97) a -=32;
           result = (char)a;
           sb.setCharAt(0, result);
           System.out.println(sb);

           
        
        
    }
    
}
