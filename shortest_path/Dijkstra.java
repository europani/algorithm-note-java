package shortest_path;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

// https://www.acmicpc.net/problem/1753
public class Dijkstra {

    static final int INF = Integer.MAX_VALUE;
    static int N, M, start;
    static ArrayList<Edge>[] graph;
    static int[] distance;

    static class Edge implements Comparable<Edge> {
        public int idx, weight;

        public Edge(int idx, int weight) {
            this.idx = idx;
            this.weight = weight;
        }

        @Override
        public int compareTo(Edge o) {
            return this.weight - o.weight;
        }
    }

    static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        start = Integer.parseInt(br.readLine());

        graph = new ArrayList[N + 1];
        for (int i = 1; i <= N; i++) {
            graph[i] = new ArrayList<>();
        }
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());

            graph[a].add(new Edge(b, c));
        }

        distance = new int[N + 1];
        for (int i = 1; i <= N; i++) {
            distance[i] = INF;
        }
    }

    static void dijkstra(int start) {
        PriorityQueue<Edge> queue = new PriorityQueue();
        queue.add(new Edge(start, 0));
        distance[start] = 0;

        while (!queue.isEmpty()) {
            Edge edge = queue.poll();

            if (distance[edge.idx] < edge.weight)  continue;

            for (Edge e : graph[edge.idx]) {
                int cost = edge.weight + e.weight;
                if (cost < distance[e.idx]) {
                    distance[e.idx] = cost;
                    queue.add(e);
                }
            }
        }
    }

    public static void main(String[] args) throws IOException {
        input();
        dijkstra(start);

        for (int i = 1; i <= N; i++) {
            if (distance[i] == INF) {
                System.out.println("INF");
            } else {
                System.out.println(distance[i]);
            }
        }
    }
}
