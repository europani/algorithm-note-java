package search;

import java.util.Arrays;
import java.util.Scanner;

/*
[
[1, 2, 3, 4],
[5, 6, 7, 8],
[9, 10, 11, 12]
]

Time Complexity: O(logN)
Space Complexity: O(1)
*/
public class BinarySearch2D {

    static int N, M, target;
    static int[][] arr;

    static void input() {
        Scanner scan = new Scanner(System.in);
        N = scan.nextInt();     // 2차원 배열의 행 갯수 ex) 3
        M = scan.nextInt();     // 2차원 배열의 열 갯수 ex) 4
        target = scan.nextInt();

        arr = new int[N][M];
        int p = 1;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                arr[i][j] = p++;
            }
        }
    }

    static int[] search(int start, int end) {
        while (start <= end) {
            int mid = (start + end) / 2;        // ex) 5
            int midX = mid / M;                 // ex) 1
            int midY = mid % M;                 // ex) 1

            if (arr[midX][midY] == target) {
                return new int[] {midX, midY};
            } else if (arr[midX][midY] > target) {
                end = mid-1;
            } else {
                start = mid+1;
            }
        }

        return new int[] {-1, -1};
    }

    public static void main(String[] args) {
        input();
        int[] result = search(0, N*M - 1);

        if (result != null && result[0] != -1 && result[1] != -1) {
            System.out.println(Arrays.toString(result) + " 에서 발견");
        } else {
            System.out.println("발견하지 못함");
        }
    }
}
