package com.priyakdey.blind75;

import java.util.Arrays;
import java.util.Comparator;

/**
 * @author Priyak Dey
 */
public class NonOverlappingIntervals {

    public int eraseOverlapIntervals(int[][] intervals) {
        int length = intervals.length;
        if (length == 1) {
            return 0;
        }

        Arrays.sort(intervals, Comparator.comparing((int[] interval) -> interval[0])
            .thenComparing((int[] interval) -> interval[1]));

        int count = 0;

        int lastEndTime = intervals[0][1];
        for (int i = 1; i < length; i++) {
            int currStartTime = intervals[i][0];
            int currEndTime = intervals[i][1];

            if (currStartTime >= lastEndTime) {
                // non-overlapping interval. Keeping the interval.
                lastEndTime = currEndTime;
            } else {
                // overlapping interval and can be skipped
                count++;
            }
        }

        return count;
    }


    public static void main(String[] args) {
        int[][] intervals =
            new int[][] {{-52, 31}, {-73, -26}, {82, 97}, {-65, -11}, {-62, -49}, {95, 99},
                {58, 95}, {-31, 49}, {66, 98}, {-63, 2}, {30, 47}, {-40, -26}};
        new NonOverlappingIntervals().eraseOverlapIntervals(intervals);
    }
}
