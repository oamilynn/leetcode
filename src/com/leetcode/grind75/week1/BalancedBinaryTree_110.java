package com.leetcode.grind75.week1;

import com.leetcode.model.TreeNode;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class BalancedBinaryTree_110 {

    public boolean isBalanced(TreeNode root) {
        return getBalancedHeight(root) >= 0;
    }

    public int getBalancedHeight(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int leftHeight = getBalancedHeight(root.left);
        int rightHeight = getBalancedHeight(root.right);
        if (leftHeight == -1 || rightHeight == -1 || Math.abs(leftHeight - rightHeight) > 1) {
            return -1;
        }
        return Math.max(leftHeight, rightHeight) + 1;
    }

    @Test
    public void test() {
        assertTrue(isBalanced(TreeNode.createTree(new Integer[]{3, 9, 20, null, null, 15, 7})));
        assertTrue(isBalanced(TreeNode.createTree(new Integer[]{1, 2, 3, 4, 5, 6, null, 8})));
        assertFalse(isBalanced(TreeNode.createTree(new Integer[]{1, 2, 2, 3, 3, null, null, 4, 4})));
    }

}
