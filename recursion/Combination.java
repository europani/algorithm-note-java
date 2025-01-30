package recursion;

import java.io.*;
import java.util.StringTokenizer;

/*
N = 4, M = 2

1 2
1 3
1 4
2 3
2 4
3 4
*/
class Combination {

    static int N, M;
    static int[] arr;

    static void input() {
        FastReader scan = new FastReader();
        N = scan.nextInt();
        M = scan.nextInt();

        arr = new int[M];
    }

    static void dfs(int idx, int cnt) {
        if (cnt == M) {
            for (int i : arr) {
                System.out.print(i + " ");
            }
            System.out.println();
            return;
        }

        for (int i = idx+1; i <= N; i++) {
            arr[cnt] = i;
            dfs(i, cnt + 1);
        }
    }

    public static void main(String[] args) {
        input();
        dfs(0, 0);
    }


    static class FastReader {
        BufferedReader br;
        StringTokenizer st;

        public FastReader() {
            br = new BufferedReader(new InputStreamReader(System.in));
        }

        public FastReader(String s) throws FileNotFoundException {
            br = new BufferedReader(new FileReader(new File(s)));
        }

        String next() {
            while (st == null || !st.hasMoreElements()) {
                try {
                    st = new StringTokenizer(br.readLine());
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            return st.nextToken();
        }

        int nextInt() {
            return Integer.parseInt(next());
        }

        long nextLong() {
            return Long.parseLong(next());
        }

        double nextDouble() {
            return Double.parseDouble(next());
        }

        String nextLine() {
            String str = "";
            try {
                str = br.readLine();
            } catch (IOException e) {
                e.printStackTrace();
            }
            return str;
        }
    }

}
