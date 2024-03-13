package com.sde.day_20_binary_search_tree;

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
    public TreeNode searchBST(TreeNode root, int val) {
        if(root == null) return null;
        
        if(root.val == val) return root;
        
        TreeNode lroot = searchBST(root.left, val);
        TreeNode rroot = searchBST(root.right, val);
        
        if(lroot != null) return lroot;
        if(rroot != null) return rroot;
        
        return null;
    }
}