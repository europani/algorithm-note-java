package search;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SequentialSearch {

    static int N, target;
    static int[] arr;

    static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        arr = new int[N];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        target = Integer.parseInt(br.readLine());
    }

    static int search() {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == target) {
                return i;
            }
        }
        return -1;
    }

    public static void main(String[] args) throws IOException {
        input();
        int result = search();
        if (result != -1) {
            System.out.println(result + " 에서 발견");
        } else {
            System.out.println("발견하지 못함");
        }
    }
}
