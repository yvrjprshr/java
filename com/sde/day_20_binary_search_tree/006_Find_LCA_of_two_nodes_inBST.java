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
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if(root == null) return null;
        
        if(root == p || root == q){
            return root;
        }
        
        TreeNode lt = lowestCommonAncestor(root.left, p, q);  
        TreeNode rt = lowestCommonAncestor(root.right, p, q);
        
        if(lt == null) return rt;
        
        if(rt == null) return lt;
        
        return root;
           
    }
}