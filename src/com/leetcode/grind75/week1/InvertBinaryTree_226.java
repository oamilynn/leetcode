package com.leetcode.grind75.week1;

import com.leetcode.model.TreeNode;

public class InvertBinaryTree_226 {

    public TreeNode invertTree(TreeNode root) {
        if (root == null) {
            return null;
        }
        TreeNode newRoot = new TreeNode(root.val);
        newRoot.left = invertTree(root.right);
        newRoot.right = invertTree(root.left);
        return newRoot;
    }

}
