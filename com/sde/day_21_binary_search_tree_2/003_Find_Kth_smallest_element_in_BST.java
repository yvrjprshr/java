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
    public int cnt = 0, ans;
    public void dfs(TreeNode root, int k){
        if(root == null) return;
        dfs(root.left, k);
        cnt++;
        if(cnt == k){
            ans = root.val;
        }
        
        dfs(root.right, k);
    }
    public int kthSmallest(TreeNode root, int k) {
        cnt = 0;
        dfs(root, k);
        return ans;
    }
}