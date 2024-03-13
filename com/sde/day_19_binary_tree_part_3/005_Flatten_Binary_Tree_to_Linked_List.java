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
    public void flatten(TreeNode root) {
        if(root == null) return;
        
        Stack<TreeNode> stack = new Stack<>();
        
        while(true){
            if(root.right != null){
                stack.push(root.right);
            }
            
            if(root.left == null){
                if(stack.isEmpty()){
                    return;
                }
                root.right = stack.pop();
            }else{
                root.right = root.left;
                root.left = null;
            }
            
            root = root.right;
        }
    }
}