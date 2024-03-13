package com.sde.day_18_binary_tree_part_2;

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode() {}
    TreeNode(int val) { this.val = val; }
    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}

class Solution {
    public boolean isSameTree(TreeNode p, TreeNode q) {
        if(p == null && q==null) return true;
        if(p == null || q==null) return false;
        if(p.val != q.val) return false;
        boolean left_subtree = isSameTree(p.left, q.left);
        boolean right_subtree = isSameTree(p.right, q.right);
        if(!left_subtree || !right_subtree) return false;
        return true;
    }
}
