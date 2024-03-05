package com.priyakdey.solutions;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

/**
 * <a href="https://leetcode.com/problems/insert-interval/description/">Problem Statement</a>
 *
 * @author Priyak Dey
 */
public class InsertInterval {

    public int[][] insert(int[][] intervals, int[] newInterval) {
        int intervalsLength = intervals.length;
        List<int[]> newIntervals = new ArrayList<>(intervalsLength + 1);

        newIntervals.add(newInterval);
        newIntervals.addAll(Arrays.asList(intervals));

        newIntervals.sort(Comparator.comparing((int[] interval) -> interval[0])
            .thenComparingInt((int[] interval) -> interval[1]));

        List<int[]> mergedIntervals = new ArrayList<>(intervalsLength + 1);
        mergedIntervals.add(newIntervals.getFirst());

        int newIntervalsLength = newIntervals.size();
        for (int i = 1; i < newIntervalsLength; i++) {
            int currStartTime = newIntervals.get(i)[0];
            int currEndTime   = newIntervals.get(i)[1];

            int prevStartTime = mergedIntervals.getLast()[0];
            int prevEndTime   = mergedIntervals.getLast()[1];

            if (currStartTime == prevStartTime || currStartTime <= prevEndTime) {
                mergedIntervals.getLast()[0] = Math.min(currStartTime, prevStartTime);
                mergedIntervals.getLast()[1] = Math.max(currEndTime, prevEndTime);
            } else {
                mergedIntervals.add(new int[] {currStartTime, currEndTime});
            }
        }


        return mergedIntervals.toArray(new int[mergedIntervals.size()][2]);
    }

}
