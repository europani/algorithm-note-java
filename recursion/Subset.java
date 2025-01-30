package recursion;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

/*
N = 4

[
[],
[1],
[1, 2],
[1, 2, 3],
[1, 2, 3, 4],
[1, 2, 4],
[1, 3],
[1, 3, 4],
[1, 4],
[2],
[2, 3],
[2, 3, 4],
[2, 4],
[3],
[3, 4],
[4]
]
*/
class Subset {

    static int N;
    static List<List<Integer>> subsets = new ArrayList<>();

    static void input() {
        FastReader scan = new FastReader();
        N = scan.nextInt();
    }

    static void dfs(int idx, List<Integer> subList) {
        subsets.add(new ArrayList(subList));        // 복사본 저장

        for (int i = idx+1; i <= N; i++) {
            subList.add(i);
            dfs(i, subList);
            subList.remove(subList.size() - 1);
        }
    }

    public static void main(String[] args) {
        input();
        dfs(0, new ArrayList<>());

        System.out.println(subsets);
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
