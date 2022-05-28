package recursion;

import java.util.Scanner;

public class Factorial {
    static int N;

    static int factorial(int n) {
        if (n <= 1) {
            return 1;
        }
        return n * factorial(n - 1);
    }

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        N = scan.nextInt();

        System.out.println(factorial(N));
    }
}
