package com.priyakdey.solutions;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.IntStream;

/**
 * <a href="https://leetcode.com/problems/number-of-connected-components-in-an-undirected-graph/description/">Problem Statement</a>
 *
 * @author Priyak Dey
 */
public class NumberOfConnectedComponentsInAnUndirectedGraph {

    public int countComponents(int n, int[][] edges) {
        if (n < 1) throw new IllegalArgumentException("invalid input");
        if (n == 1) return 1;
        if (n == 2) return edges.length != 0 ? 1 : 2;

        int connectedComponents = 0;

        Map<Integer, List<Integer>> adjList = toAdjList(n, edges);
        Set<Integer> visited = HashSet.newHashSet(n);
        Deque<Integer> stack = new ArrayDeque<>();

        for (Integer src : adjList.keySet()) {
            if (!visited.contains(src)) {
                connectedComponents++;

                visited.add(src);
                stack.push(src);

                while (!stack.isEmpty()) {
                    Integer vertex = stack.poll();

                    for (int dest : adjList.get(vertex)) {
                        if (!visited.contains(dest)) {
                            visited.add(dest);
                            stack.push(dest);
                        }
                    }
                }
            }

        }

        return connectedComponents;
    }

    private Map<Integer, List<Integer>> toAdjList(int n, int[][] edges) {
        Map<Integer, List<Integer>> adjList = HashMap.newHashMap(n);
        IntStream.range(0, n).forEach(i -> adjList.put(i, new ArrayList<>()));

        for (int[] edge : edges) {
            int src = edge[0];
            int dst = edge[1];
            adjList.get(src).add(dst);
            adjList.get(dst).add(src);
        }

        return adjList;
    }

}
