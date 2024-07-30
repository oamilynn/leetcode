package com.leetcode.model;

public class TreeNode {
    public int val;
    public TreeNode left;
    public TreeNode right;

    public TreeNode() {
    }

    public TreeNode(int val) {
        this.val = val;
    }

    public TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }

    public static TreeNode createTree(Integer[] val) {
        return createTree(val, 0);
    }

    public static TreeNode createTree(Integer[] val, int i) {
        if (i >= val.length || val[i] == null) {
            return null;
        }
        return new TreeNode(val[i],
                createTree(val, i * 2 + 1),
                createTree(val, i * 2 + 2));
    }

}
