package recursion;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

class Subset {

    static int N;
    static List result = new ArrayList();

    static void input() {
        FastReader scan = new FastReader();
        N = scan.nextInt();
    }

    static void dfs(int idx, List list) {
        result.add(new ArrayList<>(list));

        for (int i = idx+1; i <= N; i++) {
            list.add(i);
            dfs(i, list);
        }
    }

    public static void main(String[] args) {
        input();
        dfs(0, new ArrayList());

        System.out.println(result);
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
