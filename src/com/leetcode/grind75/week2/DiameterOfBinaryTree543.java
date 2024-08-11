package com.leetcode.grind75.week2;

import com.leetcode.model.TreeNode;

public class DiameterOfBinaryTree543 {

    private class Parameters {
        public int diameter;
        public int height;

        public Parameters(int diameter, int height) {
            this.diameter = diameter;
            this.height = height;
        }
    }

    // TODO: inefficient
    public int diameterOfBinaryTree(TreeNode root) {
        return parametersOfBinaryTree(root).diameter - 1;
    }

    public Parameters parametersOfBinaryTree(TreeNode root) {
        if (root == null) {
            return new Parameters(0, 0);
        }
        Parameters left = parametersOfBinaryTree(root.left);
        Parameters right = parametersOfBinaryTree(root.right);
        int diameter = left.height + right.height + 1;
        return new Parameters(Math.max(Math.max(left.diameter, right.diameter), diameter),
                Math.max(left.height, right.height) + 1);
    }
}
