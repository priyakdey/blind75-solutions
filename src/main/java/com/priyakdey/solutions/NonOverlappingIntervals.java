package com.priyakdey.solutions;

import java.util.Arrays;
import java.util.Comparator;

/**
 * <a href="https://leetcode.com/problems/non-overlapping-intervals/description/">Problem Statement</a>
 *
 * @author Priyak Dey
 */
public class NonOverlappingIntervals {

    public int eraseOverlapIntervals(int[][] intervals) {
        int length = intervals.length;
        if (length == 1) {
            return 0;
        }

        Arrays.sort(intervals, Comparator.comparing((int[] interval) -> interval[1]));

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

}
