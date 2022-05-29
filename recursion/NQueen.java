package recursion;

import java.util.Scanner;

public class NQueen {

    static int N, result;
    static int[] queen;

    static void input() {
        Scanner scan = new Scanner(System.in);
        N = scan.nextInt();
        queen = new int[N];
    }

    static void dfs(int x) {
        if (x == N) {
            result++;
            return;
        }

        for (int i = 0; i < N; i++) {
            queen[x] = i;
            if (check(x)) {
                dfs(x + 1);
            }
        }
    }

    static boolean check(int i) {
        for (int j = 0; j < i; j++) {
            if (queen[j] == queen[i] || queen[j]-j == queen[i]-i || queen[j]+j == queen[i]+i) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        input();
        dfs(0);
        System.out.println(result);
    }
}
