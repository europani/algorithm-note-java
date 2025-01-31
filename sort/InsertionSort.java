package sort;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
Time Complexity: O(n^2)
Space Complexity: O(1)
*/
public class InsertionSort {
    static int N;
    static int[] nums;

    static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        nums = new int[N];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            nums[i] = Integer.parseInt(st.nextToken());
        }
    }

    static void sort() {
        int tmp;
        for (int i = 1; i < N; i++) {
            for (int j = i; j > 0; j--) {
                if (nums[j-1] > nums[j]) {
                    tmp = nums[j-1];
                    nums[j-1] = nums[j];
                    nums[j] = tmp;
                } else {
                    break;
                }
            }

        }
    }

    public static void main(String[] args) throws IOException {
        input();
        sort();

        for (int i : nums) {
            System.out.print(i + " ");
        }
    }
}
