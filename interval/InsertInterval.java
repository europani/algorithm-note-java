package interval;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
[1, 3], [6, 9] + [2, 5]
-> [1, 5], [6, 9]
*/
public class InsertInterval {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        List<int[]> result = new ArrayList<>();
        int N = intervals.length;
        int i = 0;

        // newInterval 보다 작은 구간 추가
        while (i < N && intervals[i][1] < newInterval[0]) {
            result.add(intervals[i]);
            i++;
        }

        // newInterval 과 겹치는 구간 병합!!!
        while (i < N && intervals[i][0] <= newInterval[1]) {
            newInterval[0] = Math.min(newInterval[0], intervals[i][0]);
            newInterval[1] = Math.max(newInterval[1], intervals[i][1]);
            i++;
        }
        result.add(newInterval);

        // 나머지 구간 추가
        while (i < N) {
            result.add(intervals[i]);
            i++;
        }

        return result.toArray(new int[result.size()][]);

    }
}
