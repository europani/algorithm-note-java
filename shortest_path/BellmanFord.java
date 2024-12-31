package shortest_path;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

// https://www.acmicpc.net/problem/11657
public class BellmanFord {

    static final int INF = Integer.MAX_VALUE;
    static int N, M;
    static ArrayList<Edge> graph = new ArrayList<>();
    static int[] distance;

    static class Edge {
        public int from, to, cost;

        public Edge(int from, int to, int cost) {
            this.from = from;
            this.to = to;
            this.cost = cost;
        }
    }

    static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());

            graph.add(new Edge(a, b, c));
        }

        distance = new int[N + 1];
        Arrays.fill(distance, INF);
//        for (int i = 1; i <= N; i++) {
//            distance[i] = INF;
//        }
    }

    static boolean bellmanFord(int start) {
        distance[start] = 0;

        for (int i = 1; i <= N; i++) {
            for (Edge edge : graph) {
                int cur = edge.from;
                int next = edge.to;
                int cost = edge.cost;

                if (distance[cur] != INF && distance[next] > distance[cur] + cost) {
                    distance[next] = distance[cur] + cost;

                    // N번째 라운드에서도 값이 갱신된다면 음수 순환 존재
                    if (i == N-1) {
                        return true;
                    }
                }
            }
        }

        return false; // 음수 사이클 없음
    }

    public static void main(String[] args) throws IOException {
        input();
        boolean negativeCycle = bellmanFord(1);

        if (negativeCycle) {
            System.out.println("-1");
        }
        else {
            for (int i = 2; i <= N; i++) {
                if (distance[i] == INF) {
                    System.out.println("-1");
                } else {
                    System.out.println(distance[i]);
                }
            }
        }
    }
}
