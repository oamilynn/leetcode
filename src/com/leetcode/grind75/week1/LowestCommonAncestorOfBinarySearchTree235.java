package com.leetcode.grind75.week1;

import com.leetcode.model.TreeNode;

import java.util.HashSet;
import java.util.Set;

public class LowestCommonAncestorOfBinarySearchTree235 {

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (p.val > root.val && q.val > root.val) {
            return lowestCommonAncestor(root.right, p, q);
        }
        if (p.val < root.val && q.val < root.val) {
            return lowestCommonAncestor(root.left, p, q);
        }
        return root;
    }
}
