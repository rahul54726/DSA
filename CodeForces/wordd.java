import java.util.*;;
public final class wordd {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        String str = sc.next();
        String newstr ="";
        
    
        int up=0;
        int low=0;
        for(int i=0;i<str.length();i++){
            int as=(int)str.charAt(i);
            if(as>=97 && as<=122) low++;
            else up++;
        }
        
        if(up>low){
            for(int i=0;i<str.length();i++){
                newstr = newstr+str.charAt(i);
            }
                String sstr = newstr.toUpperCase();
                System.out.println(sstr);
            }
            else{
                for(int i =0;i<str.length();i++){
                    newstr=newstr+str.charAt(i);
                }
                String sstr=newstr.toLowerCase();
                System.out.println(sstr);
            }
        }
        
        
}    
    

