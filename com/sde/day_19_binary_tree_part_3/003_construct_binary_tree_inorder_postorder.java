package com.sde.day_19_binary_tree_part_3;

import java.util.*;

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
    public TreeNode dfs(int inorder[], int instart, int inend, int postorder[], int poststart, int postend, HashMap<Integer, Integer> inorder_map){
        if(instart > inend || poststart > postend) return null;
        
        TreeNode root = new TreeNode(postorder[postend]);
        
        int inorder_index = inorder_map.get(root.val);
        int left_nodes = inorder_index-instart;
        
        root.left = dfs(inorder, instart, inorder_index-1, postorder, poststart, poststart+left_nodes-1, inorder_map);
        root.right = dfs(inorder, inorder_index+1, inend, postorder, poststart+left_nodes, postend-1, inorder_map);
        
        return root;
    }
    
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        HashMap<Integer, Integer> inorder_map = new HashMap<>();
        for(int i=0; i<inorder.length; i++){
            inorder_map.put(inorder[i], i);
        }
        TreeNode root = dfs(inorder, 0, inorder.length-1, postorder, 0, postorder.length-1, inorder_map);
        return root;
    }
}