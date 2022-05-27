package search;

import java.util.Scanner;

public class SequentialSearch {

    static int N;
    static int[] arr = {1, 2, 3, 4, 5};
    static int target;


    static void input() {
        Scanner scan = new Scanner(System.in);
        target = scan.nextInt();
    }

    static int search() {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == target) {
                return i;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        input();
        int result = search();
        if (result != -1) {
            System.out.println(result + " 에서 발견");
        } else {
            System.out.println("발견하지 못함");
        }
    }
}
