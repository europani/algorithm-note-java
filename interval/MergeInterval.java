package interval;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
[1, 3], [2, 6], [8, 10]
-> [1, 6], [8, 10]
*/
public class MergeInterval {
    public int[][] merge(int[][] intervals) {
        if (intervals.length <= 1) return intervals;

        // 시작점 기준으로 정렬
        Arrays.sort(intervals, (a, b) -> Integer.compare(a[0], b[0]));

        List<int[]> merged = new ArrayList<>();
        int[] prev = intervals[0];

        for (int i = 1; i < intervals.length; i++) {
            int[] interval = intervals[i];
            if (interval[0] <= prev[1]) {        // 겹치는 경우
                prev[1] = Math.max(prev[1], interval[1]);
            } else {                             // 겹치지 않는 경우
                merged.add(prev);
                prev = interval;
            }
        }
        merged.add(prev);

        return merged.toArray(new int[merged.size()][]);
    }
}
