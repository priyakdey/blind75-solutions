package com.priyakdey.solutions;

import java.util.Arrays;

/**
 * <a href="https://leetcode.com/problems/meeting-rooms-ii/description/">Problem Statement</a>
 *
 * @author Priyak Dey
 */
public class MeetingRoomsII {

    public int minMeetingRooms(int[][] intervals) {
        if (intervals == null || intervals.length == 0 || intervals[0].length != 2) {
            throw new IllegalArgumentException("invalid input");
        }

        int length = intervals.length;
        if (length == 1) return 1;


        int[] startTimes = Arrays.stream(intervals).map(arr -> arr[0])
            .mapToInt(Integer::valueOf).sorted().toArray();
        int[] endTimes = Arrays.stream(intervals).map(arr -> arr[1])
            .mapToInt(Integer::valueOf).sorted().toArray();

        int totalRooms = 1;
        int emptyRooms = 0;

        int i = 1, j = 0;

        while (i < length && j < length) {
            if (startTimes[i] < endTimes[j]) {
                if (emptyRooms == 0) {
                    totalRooms++;
                } else {
                    emptyRooms--;
                }
                i++;
            } else {
                emptyRooms++;
                j++;
            }
        }

        return totalRooms;
    }

}
