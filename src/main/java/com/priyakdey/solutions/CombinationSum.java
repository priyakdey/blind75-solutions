package com.priyakdey.solutions;

import java.util.ArrayList;
import java.util.List;

/**
 * <a href="https://leetcode.com/problems/combination-sum/description/">Problem Statement</a>
 *
 * @author Priyak Dey
 */
public class CombinationSum {

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> combinations = new ArrayList<>();
        combinationSum(candidates, 0, 0, target, new ArrayList<>(), combinations);
        return combinations;
    }

    private void combinationSum(int[] candidates, int index, int currSum, int target,
                                List<Integer> combination, List<List<Integer>> combinations) {
        int length = candidates.length;
        if (currSum == target) {
            combinations.add(new ArrayList<>(combination));
            return;
        }

        if (currSum > target) {
            return;
        }

        for (int i = index; i < length; i++) {
            combination.add(candidates[i]);
            combinationSum(candidates, i, currSum + candidates[i], target, combination,
                combinations);
            combination.removeLast();
        }
    }
}
