import java.util.*;

public class FibonacciSeries {
    public static int fibonacci(int n) {
        if (n == 0 || n == 1) {
            return n;
        } else {
            int c = fibonacci(n - 1) + fibonacci(n - 2);
            return c;
        }
    }

    public static void main(String arg[]) {
        Scanner sc = new Scanner(System.in);
        System.out.print("The term of Fibonacci Series : ");
        int term= sc.nextInt();
        System.out.println(fibonacci(term));

    }

}
