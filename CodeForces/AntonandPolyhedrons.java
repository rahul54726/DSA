import java.util.*;
public class AntonandPolyhedrons {
    public static void main(String[] args) {
        Scanner sc= new Scanner(System.in);
        int n=sc.nextInt();
        int count=0;
        String str[] = new String[n];
        for(int i=0;i<n;i++){
            str[i]=sc.next();
        }
        String a = "Tetrahedron";
        String b = "Cube";
        String c = "Octahedron";
        String d = "Dodecahedron";
        String e = "Icosahedron";
        for(int i=0;i<n;i++){
            if(a.compareTo(str[i])==0) count+=4;
            else if(b.compareTo(str[i])==0) count+=6;
            else if(c.compareTo(str[i])==0) count+=8;
            else if(d.compareTo(str[i])==0) count+=12;
            else if(e.compareTo(str[i])==0) count+=20;
            
        }
        System.out.println(count);
        
    }
    
}
