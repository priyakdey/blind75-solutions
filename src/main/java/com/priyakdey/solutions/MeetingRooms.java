package com.priyakdey.solutions;

import java.util.Arrays;
import java.util.Comparator;

/**
 * <a href="https://leetcode.com/problems/meeting-rooms/description/">Problem Statement</a>
 *
 * @author Priyak Dey
 */
public class MeetingRooms {

    public boolean canAttendMeetings(int[][] intervals) {
        int length = intervals.length;

        if (length <= 1) return true;

        Arrays.sort(intervals,
            Comparator.comparing((int[] arr) -> arr[0]).thenComparing((int[] arr) -> arr[0]));

        for (int i = 1; i < length; i++) {
            if (intervals[i][0] < intervals[i - 1][1]) {
                return false;
            }
        }

        return true;
    }

}
