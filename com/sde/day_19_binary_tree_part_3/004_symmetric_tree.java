package com.sde.day_19_binary_tree_part_3;

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
    public boolean dfs(TreeNode node1, TreeNode node2){
        if(node1 == null && node2 == null) return true;
        if(node1 == null || node2 == null) return false;
        
        if(node1.val != node2.val) return false;
        
        boolean res1 = dfs(node1.left, node2.right);
        boolean res2 = dfs(node1.right, node2.left);
        
        if(!res1 || !res2){
            return false;
        }
        
        return true;
    }
    public boolean isSymmetric(TreeNode root) {
        if(root == null) return true;
        boolean res = dfs(root.left, root.right);
        return res;
    }
}