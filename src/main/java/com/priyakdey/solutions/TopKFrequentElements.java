package com.priyakdey.solutions;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

/**
 * <a href="https://leetcode.com/problems/top-k-frequent-elements/description/">Problem Statement</a>
 *
 * @author Priyak Dey
 */
public class TopKFrequentElements {

    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> freqMap = new HashMap<>();
        for (int num : nums) {
            freqMap.put(num, freqMap.getOrDefault(num, 0) + 1);
        }

        PriorityQueue<Pair> minHeap = new PriorityQueue<>(k, Comparator.comparing(Pair::freq));

        for (Map.Entry<Integer, Integer> entry : freqMap.entrySet()) {
            int freq = entry.getValue();

            if (minHeap.size() == k && minHeap.peek().freq > freq) {
                continue;
            }

            if (minHeap.size() == k) {
                minHeap.poll();
            }

            Pair pair = new Pair(entry.getKey(), freq);
            minHeap.offer(pair);
        }

        int[] topElements = new int[k];
        int cursor = 0;

        while (!minHeap.isEmpty()) {
            int num = minHeap.poll().value;
            topElements[cursor++] = num;
        }

        return topElements;
    }

    private record Pair(int value, int freq) {
    }

}
