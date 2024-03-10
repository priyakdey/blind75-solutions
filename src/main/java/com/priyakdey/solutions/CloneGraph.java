package com.priyakdey.solutions;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * <a href="https://leetcode.com/problems/clone-graph/description/">Problem Statement</a>
 *
 * @author Priyak Dey
 */
public class CloneGraph {

    public Node cloneGraph(Node node) {
        if (node == null) return null;

        Map<Node, Node> nodeMap = new HashMap<>();
        Set<Integer> visited = new HashSet<>();

        Deque<Node> queue = new ArrayDeque<>();

        Node nodeCl = new Node(node.val);
        queue.offer(node);
        nodeMap.put(node, nodeCl);
        visited.add(node.val);

        while (!queue.isEmpty()) {
            Node polled = queue.poll();

            for (Node neighbor : polled.neighbors) {
                if (!nodeMap.containsKey(neighbor)) {
                    Node neighborCl = new Node(neighbor.val);
                    nodeMap.put(neighbor, neighborCl);
                }
                nodeMap.get(polled).neighbors.add(nodeMap.get(neighbor));

                if (!visited.contains(neighbor.val)) {
                    queue.offer(neighbor);
                    visited.add(neighbor.val);
                }
            }

        }

        return nodeCl;
    }

    private static class Node {
        int val;
        List<Node> neighbors;

        Node() {
            val = 0;
            neighbors = new ArrayList<Node>();
        }

        Node(int _val) {
            val = _val;
            neighbors = new ArrayList<Node>();
        }

        Node(int _val, ArrayList<Node> _neighbors) {
            val = _val;
            neighbors = _neighbors;
        }
    }

}
