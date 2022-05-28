package recursion;

import java.util.Scanner;

public class Fibonacci {
    static int N;

    static int fibonacci(int n) {
        if (n <= 1) {
            return n;
        }
        return fibonacci(n-2) + fibonacci(n-1);
    }

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        N = scan.nextInt();

        System.out.println(fibonacci(N));
    }
}
