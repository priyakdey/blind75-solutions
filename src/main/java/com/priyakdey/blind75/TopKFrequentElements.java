package com.priyakdey.blind75;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

/**
 * @author Priyak Dey
 */

class MaxHeap {
    private final List<Integer> data;

    MaxHeap() {
        this.data = new ArrayList<>();
    }

    public void push(int element) {
        data.add(element);

        // heapify the tree bottom up
        int currIndex = data.size() - 1;
        while (currIndex >= 1) {
            int parentIndex = getParentIndex(currIndex);
            if (data.get(currIndex) > data.get(parentIndex)) {
                swap(currIndex, parentIndex);
            } else {
                break;
            }

            currIndex = parentIndex;
        }
    }


    public int pop() {
        int root = data.get(0);
        data.set(0, data.get(data.size() - 1));
        // slice the array
        data.remove(data.size() - 1);

        // heapify the array from top down
        int currIndex = 0;
        while (currIndex < data.size()) {
            int leftChildIndex = getLeftChildIndex(currIndex);
            int rightChildIndex = getRightChildIndex(currIndex);

            if (leftChildIndex >= data.size()) {
                break;
            }

            int swapIndex = leftChildIndex;
            if (rightChildIndex < data.size() &&
                data.get(rightChildIndex) > data.get(leftChildIndex)) {
                swapIndex = rightChildIndex;
            }

            if (data.get(swapIndex) > data.get(currIndex)) {
                swap(currIndex, swapIndex);
            } else {
                break;
            }

            currIndex = swapIndex;

        }

        return root;
    }

    public boolean isEmpty() {
        return data.isEmpty();
    }

    // ---------- private methods ----------------

    private void swap(int i, int j) {
        int temp = data.get(i);
        data.set(i, data.get(j));
        data.set(j, temp);
    }

    private int getLeftChildIndex(int i) {
        return 2 * i + 1;
    }

    private int getRightChildIndex(int i) {
        return 2 * i + 2;
    }

    private int getParentIndex(int i) {
        return (i - 1) / 2;
    }
}

public class TopKFrequentElements {

    public int[] topKFrequent(int[] nums, int k) {
        // get the count of every element
        // group all elements by their count

        Map<Integer, List<Integer>> freqToElementsMap = Arrays.stream(nums)
            .boxed()
            .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()))
            .entrySet().stream()
            .collect(Collectors.groupingBy(e -> Math.toIntExact(e.getValue()),
                Collectors.mapping(Map.Entry::getKey, Collectors.toList())));

        MaxHeap heap = new MaxHeap();
        for (int freq : freqToElementsMap.keySet()) {
            heap.push(freq);
        }

        List<Integer> frequentElements = new ArrayList<>(k);

        while (!heap.isEmpty() && k != 0) {
            int freq = heap.pop();
            List<Integer> elements = freqToElementsMap.get(freq);

            if (elements.size() > k) {
                elements = elements.subList(0, k);
            }

            frequentElements.addAll(elements);
            k = k - elements.size();
        }

        return frequentElements.stream().mapToInt(Integer::valueOf).toArray();
    }

}
