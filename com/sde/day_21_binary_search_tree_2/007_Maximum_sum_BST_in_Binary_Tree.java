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
    public int ans = 0;
    
    public int maxSumBST(TreeNode root) {
        postorder(root);
        return ans;
    }
    
    public int[] postorder(TreeNode root){
        if(root == null) return new int[]{Integer.MAX_VALUE, Integer.MIN_VALUE, 0};
        
        int [] left = postorder(root.left);
        int [] right = postorder(root.right);
        
        if((left != null && right != null && root.val > left[1] && root.val < right[0]) == false){
            return null;
        }
        
        int sum = left[2] + right[2] + root.val;
        ans = Math.max(ans, sum);
        
        int mini = Math.min(root.val, left[0]);
        int maxi = Math.max(root.val, right[1]);
        
        return new int[]{mini, maxi, sum};
    }
}
