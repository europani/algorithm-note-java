package dp;

import java.util.Scanner;

public class Fibonacci {

    static int N;
    static int[] dp;

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        N = scan.nextInt();

        dp = new int[N+1];
        dp[1]=1;

        for (int i = 2; i < N+1; i++) {
            dp[i] = dp[i-2] + dp[i-1];
        }

        System.out.println(dp[N]);
    }
}
