package com.leetcode.grind75.week3;

import com.leetcode.model.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class BinaryTreeLevelOrderTraversal_102 {
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        addNodeValues(result, root, 0);
        return result;
    }

    private void addNodeValues(List<List<Integer>> result, TreeNode node, int level) {
        if (node == null) {
            return;
        }
        List<Integer> list;
        if (result.size() <= level) {
            list = new ArrayList<>();
            result.add(list);
        } else {
            list = result.get(level);
        }
        list.add(node.val);
        addNodeValues(result, node.left, level + 1);
        addNodeValues(result, node.right, level + 1);
    }
}
