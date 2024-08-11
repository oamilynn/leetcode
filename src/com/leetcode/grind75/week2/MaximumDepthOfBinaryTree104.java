package com.leetcode.grind75.week2;

import com.leetcode.model.TreeNode;

public class MaximumDepthOfBinaryTree104 {
    public int maxDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        return Math.max(maxDepth(root.left) + 1, maxDepth(root.right) + 1);
    }
}
