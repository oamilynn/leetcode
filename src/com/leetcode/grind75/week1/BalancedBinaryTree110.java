package com.leetcode.grind75.week1;

import com.leetcode.model.TreeNode;
import org.junit.jupiter.api.Test;

import java.util.HashSet;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class BalancedBinaryTree110 {

    public boolean isBalanced(TreeNode root) {
        if (root == null) {
            return true;
        }
        Set<TreeNode> levelNodes = new HashSet<>();
        Set<TreeNode> nextLevelNodes = new HashSet<>();
        levelNodes.add(root);
        boolean hasNulls = false;
        int previousNulls = 0;
        while (!levelNodes.isEmpty()) {
            for (TreeNode node : levelNodes) {
                if (previousNulls > 2) {
                    return false;
                }
                if (node.left == null || node.right == null) {
                    hasNulls = true;
                }
                if (node.left != null) {
                    nextLevelNodes.add(node.left);
                }
                if (node.right != null) {
                    nextLevelNodes.add(node.right);
                }
            }
            levelNodes = nextLevelNodes;
            nextLevelNodes = new HashSet<>();
            if (hasNulls || previousNulls > 0) {
                previousNulls++;
            }
            hasNulls = false;
        }
        return (previousNulls <= 2);
    }

    @Test
    public void test() {
        assertTrue(isBalanced(TreeNode.createTree(new Integer[]{3, 9, 20, null, null, 15, 7})));
        assertTrue(isBalanced(TreeNode.createTree(new Integer[]{1, 2, 3, 4, 5, 6, null, 8})));
        assertFalse(isBalanced(TreeNode.createTree(new Integer[]{1, 2, 2, 3, 3, null, null, 4, 4})));
    }

}
