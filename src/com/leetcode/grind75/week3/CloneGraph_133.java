package com.leetcode.grind75.week3;

import com.leetcode.model.Node;

import java.util.*;

public class CloneGraph_133 {

    public Node cloneGraph(Node node) {
        if (node == null) {
            return null;
        }
        Map<Node, Node> visited = new HashMap();
        return clone(visited, node);
    }

    private Node clone(Map<Node, Node> visited, Node node) {
        Node newNode = visited.get(node);
        if (newNode == null) {
            newNode = new Node(node.val);
            visited.put(node, newNode);
            List<Node> newNeighbours = new ArrayList<>(node.neighbors.size());
            for (Node neighbour : node.neighbors) {
                newNeighbours.add(clone(visited, neighbour));
            }
            newNode.neighbors = newNeighbours;
        }
        return newNode;
    }
}
