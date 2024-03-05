package com.priyakdey.solutions;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * <a href="https://leetcode.com/problems/find-median-from-data-stream/description/">Problem Statement</a>
 *
 * @author Priyak Dey
 */
public class MedianFinder {

    private final PriorityQueue<Integer> leftHalf;
    private final PriorityQueue<Integer> rightHalf;
    private double median;

    public MedianFinder() {
        leftHalf  = new PriorityQueue<>(Comparator.reverseOrder());
        rightHalf = new PriorityQueue<>(Comparator.naturalOrder());
    }

    public void addNum(int num) {
        if (num <= median) {
            leftHalf.offer(num);
        } else {
            rightHalf.offer(num);
        }

        reBalance();
        setMedian();
    }


    public double findMedian() {
        return median;
    }

    private void setMedian() {
        if (leftHalf.size() == rightHalf.size()) {
            median = (leftHalf.peek() + rightHalf.peek()) * 1.0 / 2;
        } else if (leftHalf.size() > rightHalf.size() ){
            median = leftHalf.peek();
        } else {
            median = rightHalf.peek();
        }
    }

    private void reBalance() {
        if (Math.abs(leftHalf.size() - rightHalf.size()) > 1) {
            if (leftHalf.size() > rightHalf.size()) {
                rightHalf.offer(leftHalf.poll());
            } else {
                leftHalf.offer(rightHalf.poll());
            }
        }
    }

}
