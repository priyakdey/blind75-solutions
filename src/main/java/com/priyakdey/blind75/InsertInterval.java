package com.priyakdey.blind75;

import java.util.Arrays;
import java.util.Comparator;

/**
 * @author Priyak Dey
 */
public class InsertInterval {

    public int[][] insert(int[][] intervals, int[] newInterval) {
        int noOfIntervals = intervals.length;
        int[][] copyOfIntervals = new int[noOfIntervals + 1][2];

        for (int i = 0; i < noOfIntervals; i++) {
            System.arraycopy(intervals[i], 0, copyOfIntervals[i], 0, 2);
        }

        copyOfIntervals[copyOfIntervals.length - 1] = newInterval;

        // Sort the intervals according to start time, if start times are same, consider the end time
        Arrays.sort(copyOfIntervals, Comparator.comparing((int[] interval) -> interval[0])
            .thenComparing((int[] interval) -> interval[1]));


        // add 1 space in intervals
        intervals = new int[noOfIntervals + 1][2];
        intervals[0] = copyOfIntervals[0];
        int cursor = 0;

        for (int i = 1; i < copyOfIntervals.length; i++) {
            int currStartTime = copyOfIntervals[i][0];
            int currEndTime = copyOfIntervals[i][1];

            int prevStartTime = intervals[cursor][0];
            int prevEndTime = intervals[cursor][1];

            int start, end;

            if (currStartTime == prevStartTime) {
                start = currStartTime;
                end = Math.max(prevEndTime, currEndTime);
            } else {
                if (currStartTime <= prevEndTime) {
                    start = prevStartTime;
                    end = Math.max(prevEndTime, currEndTime);
                } else {
                    start = currStartTime;
                    end = currEndTime;
                    cursor++;
                }
            }

            intervals[cursor] = new int[] {start, end};

        }

        return trimToSize(intervals, cursor - 0 + 1);
    }

    private int[][] trimToSize(int[][] arr, int length) {
        int[][] trimmedArr = new int[length][2];

        for (int i = 0; i < length; i++) {
            System.arraycopy(arr[i], 0, trimmedArr[i], 0, 2);
        }

        return trimmedArr;
    }

    public static void main(String[] args) {
        int[][] arr =
            new InsertInterval().insert(new int[][] {{1, 3}, {6, 9}}, new int[] {2, 5});

        System.out.println(Arrays.deepToString(arr));
    }

}
