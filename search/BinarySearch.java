package search;

import java.util.Scanner;

/*
Time Complexity: O(logN)
Space Complexity: O(1)
*/
public class BinarySearch {

    static int N, target;
    static int[] arr;

    static void input() {
        Scanner scan = new Scanner(System.in);
        N = scan.nextInt();
        target = scan.nextInt();

        arr = new int[N];
        for (int i = 0; i < N; i++) {
            arr[i] = i+1;
        }
    }

    static int search(int start, int end) {
        while (start <= end) {
            int mid = (start + end) / 2;

            if (arr[mid] == target) {
                return mid;
            } else if (arr[mid] > target) {
                end = mid-1;
            } else {
                start = mid+1;
            }
        }

        return -1;
    }

    public static void main(String[] args) {
        input();
        int result = search(0, N - 1);

        if (result != -1) {
            System.out.println(result + " 에서 발견");
        } else {
            System.out.println("발견하지 못함");
        }
    }
}
