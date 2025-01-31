package sort;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
Time Complexity: O(n^2)
Space Complexity: O(1)
*/
public class BubbleSort {
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
        for (int i = 0; i < N; i++) {
            for (int j = i+1; j < N; j++) {
                if (nums[i] > nums[j]) {
                    tmp = nums[i];
                    nums[i] = nums[j];
                    nums[j] = tmp;
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
