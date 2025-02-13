package interval;

import java.util.Arrays;

/*
[1, 3], [6, 9], [2, 4]
-> 겹치지 않게 하기 위해 [2, 4] 제거
*/
public class IntervalScheduling {
    public int eraseOverlapIntervals(int[][] intervals) {
        // 끝점 기준으로 정렬 (greedy -> 끝점이 빠른 구간을 선택해야 뒤에 더 많은 선택 가능)
        Arrays.sort(intervals, (a, b) -> Integer.compare(a[1], b[1]));

        int result = 0;
        int prevEnd = intervals[0][1];

        for (int i = 1; i < intervals.length; i++) {
            if (prevEnd > intervals[i][0]) {       // 겹치는 경우 추가
                result++;
            } else {
                prevEnd = intervals[i][1];
            }
        }

        return result;
    }
}
