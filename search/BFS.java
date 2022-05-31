package search;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class BFS {

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

    static void bfs(int start) {
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(start);
        visited[start] = true;

        while (!queue.isEmpty()) {
            int v = queue.poll();
            System.out.print(v + " ");

            for (int x : graph[v]) {
                if (!visited[x]) {
                    queue.offer(x);
                    visited[x] = true;
                }
            }
        }
    }

    public static void main(String[] args) {
        input();
        bfs(1);
    }
}
