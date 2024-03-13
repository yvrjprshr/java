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
    
    public boolean isok(TreeNode node, long mini, long maxi){
        if(node == null) return true;
        
        boolean res = true;
        
        res &= (node.val > mini && node.val < maxi);
        
        res &= isok(node.left, mini, node.val);
        res &= isok(node.right, node.val, maxi);
        
        return res;
    }
    
    public boolean isValidBST(TreeNode root) {
        long mini = Long.MIN_VALUE;
        long maxi = Long.MAX_VALUE;
        return isok(root, mini, maxi);
    }
}