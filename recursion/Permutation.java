package recursion;

import java.io.*;
import java.util.StringTokenizer;

/*
Time Complexity: O(N * N!) - 가짓수 : N!, subList 복사비용 : N
Space Complexity: O(N)
N = 4, M = 2

1 2
1 3
1 4
2 1
2 3
2 4
3 1
3 2
3 4
4 1
4 2
4 3
*/
class Permutation {

    static int N, M;
    static boolean[] visited;
    static int[] arr;

    static void input() {
        FastReader scan = new FastReader();
        N = scan.nextInt();
        M = scan.nextInt();
        visited = new boolean[N+1];
        arr = new int[M];
    }

    static void dfs(int level) {
        // Base Case
        if (level == M) {
            for (int i : arr) {
                System.out.print(i + " ");
            }
            System.out.println();
            return;
        }

        for (int i = 1; i <= N; i++) {
            if (!visited[i]) {
                visited[i] = true;
                arr[level] = i;
                dfs(level + 1);
                visited[i] = false;     // backtracking
            }
        }

    }

    public static void main(String[] args) {
        input();
        dfs(0);
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
