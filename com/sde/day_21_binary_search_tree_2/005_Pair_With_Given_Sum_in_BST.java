package com.sde.day_21_binary_search_tree_2;

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
    public boolean findTarget(TreeNode root, int k) {
        return dfs(root, root, k);
    }
    
    public boolean dfs(TreeNode node1, TreeNode node2, int k){
        if(node1 == null || node2 == null) return false;
        
        boolean res1 = search(node1, node2, k);
        boolean res2 = dfs(node1, node2.left, k);
        boolean res3 = dfs(node1, node2.right, k);
        
        return res1 || res2 || res3;
    } 
    
    public boolean search(TreeNode root, TreeNode curr, int k){
        if(root == null) return false; 
        
        boolean res1 = (root.val + curr.val == k) && (root != curr);
        boolean res2 = (root.val + curr.val < k) && search(root.right, curr, k);
        boolean res3 = (root.val + curr.val > k) && search(root.left, curr, k);
        
        return res1 || res2 || res3;
    }
}