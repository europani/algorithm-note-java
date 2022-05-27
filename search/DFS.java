package search;

import java.util.ArrayList;
import java.util.Scanner;

public class DFS {

    static int N, M;
    static ArrayList<Integer>[] graph;
    static boolean[] visited;

    static void input() {
        Scanner scan = new Scanner(System.in);
        N = scan.nextInt();
        M = scan.nextInt();
        graph = new ArrayList[N+1];

        for (int i = 1; i <= N; i++) {
            graph[i] = new ArrayList<Integer>();
        }

        for (int i = 0; i < M; i++) {
            int a = scan.nextInt();
            int b = scan.nextInt();
            graph[a].add(b);
            graph[b].add(a);
        }
        visited = new boolean[N + 1];
    }

    static void dfs(int v) {
        System.out.print(v + " ");
        visited[v] = true;

        for (int x : graph[v]) {
            if (!visited[x]) {
                dfs(x);
            }
        }
    }

    public static void main(String[] args) {
        input();
        dfs(1);
    }
}
