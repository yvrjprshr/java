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
    public int maxPathSum(TreeNode root) {
        int pt[] = new int[1];
        pt[0] = root.val;
        dfs(root, pt);
        return pt[0];
    }
    
    public int dfs(TreeNode root, int pt[]){
        if(root == null) return 0;
        
        int lwt = Math.max(0, dfs(root.left, pt));
        int rwt = Math.max(0, dfs(root.right, pt));
        
        pt[0] = Math.max(pt[0], lwt+rwt+root.val);
        
        
        return root.val + Math.max(lwt, rwt);
    }
}