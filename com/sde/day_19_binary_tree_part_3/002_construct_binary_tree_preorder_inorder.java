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
    public TreeNode dfs(int preorder[], int prestart, int preend, int inorder[], int instart, int inend, HashMap<Integer, Integer> map){
        if(instart>inend || prestart>preend) return null;
        
        TreeNode root = new TreeNode(preorder[prestart]);
        
        int inorder_index = map.get(root.val);
        int total_nodes = inorder_index-instart;
        
        root.left = dfs(preorder, prestart+1, prestart+total_nodes, inorder, instart, inorder_index-1, map);
        root.right = dfs(preorder, prestart+total_nodes+1, preend, inorder, inorder_index+1, inend, map);
        
        return root;
    }
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        HashMap<Integer, Integer> inorder_map = new HashMap<>();
        for(int i=0; i<inorder.length; i++){
            inorder_map.put(inorder[i], i);
        }
        TreeNode root = dfs(preorder, 0, preorder.length-1, inorder, 0, inorder.length-1, inorder_map);
        return root;
    }
}