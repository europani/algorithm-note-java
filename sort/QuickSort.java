package sort;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class QuickSort {
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

    static void sort(int start, int end) {
        if (start >= end) {
            return;
        }

        int pivot = start;
        int left = start + 1;
        int right = end;

        while (left <= right) {
            while (left <= end && nums[left] < nums[pivot]) {
                left++;
            }
            while (right > start && nums[right] >= nums[pivot]) {
                right--;
            }

            int tmp;
            if (left > right) {
                tmp = nums[right];
                nums[right] = nums[pivot];
                nums[pivot] = tmp;
            } else {
                tmp = nums[right];
                nums[right] = nums[left];
                nums[left] = tmp;
            }

            sort(start, right-1);
            sort(right+1, end);
        }

    }

    public static void main(String[] args) throws IOException {
        input();
        sort(0, N-1);

        for (int i : nums) {
            System.out.print(i + " ");
        }
    }
}
