package com.sde.day_21_binary_search_tree_2;

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

class BSTIterator {
    Stack<Integer> stk = new Stack<>();
    public void inorder(TreeNode root){
        if(root == null) return;

        inorder(root.right);
        stk.push(root.val);
        inorder(root.left);
    }
    
    public BSTIterator(TreeNode root) {
        inorder(root);    
    }
    
    public int next() {
        int x = stk.peek();
        stk.pop();
        return x;
    }
    
    public boolean hasNext() {
        return !stk.isEmpty();
    }
}