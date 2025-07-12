import java.util.*;

public final class Elephant {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int x = sc.nextInt();
        if (x >= 5 && x % 5 == 0) {
            System.out.println(x / 5);
        } else if (x > 5 && x % 5 == 4) {
            System.out.println((x / 5) + 1);
        }
        else if (x > 5 && x % 5 == 3) {
            System.out.println((x / 5) + 1);
        }
        else if (x > 5 && x % 5 == 2) {
            System.out.println((x / 5) + 1);
        }
        else if (x > 5 && x % 5 == 1) {
            System.out.println((x / 5) + 1);
        }
        
        else if (x >= 4 && x % 4 == 0) {
            System.out.println(x / 4);
        }
        else if (x >= 3 && x % 3 == 0) {
            System.out.println(x / 3);
        }
        else if (x >= 2 && x % 2 == 0) {
            System.out.println(x / 2);
        }
        else if(x==1) System.out.println(1);

        

    }

}
