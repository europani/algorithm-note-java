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

    static int search(int left, int right) {            // [left, right]
        while (left <= right) {
            int mid = left + (right - left) / 2;    // = (left + right) / 2 (but, prevent overflow)

            if (arr[mid] == target) {
                return mid;
            } else if (arr[mid] > target) {
                right = mid-1;                          // close쪽은 mid 불포함
            } else {
                left = mid+1;                           // close쪽은 mid 불포함
            }
        }

        return -1;
    }

    public static void main(String[] args) {
        input();
        int result = search(0, N - 1);          // [left, right] -> close

        if (result != -1) {
            System.out.println(result + " 에서 발견");
        } else {
            System.out.println("발견하지 못함");
        }
    }
}
