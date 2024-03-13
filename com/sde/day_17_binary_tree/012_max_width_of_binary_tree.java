package com.sde.day_17_binary_tree;

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
    class Data{
        TreeNode node;
        int ind;
        public Data(TreeNode node, int ind){
            this.node = node;
            this.ind = ind;
        }
    }
    public int widthOfBinaryTree(TreeNode root) {
        int max_width = 0;
        Queue<Data> q = new LinkedList<>();
        q.add(new Data(root, 0));
        
        while(!q.isEmpty()){
            int mini = q.peek().ind;
            int sz = q.size();
            int first = 0, last = 0;
            for(int i = 0; i<sz; i++){
                if(i == 0)first = q.peek().ind;
                if(i == sz-1)last = q.peek().ind;
                TreeNode node = q.peek().node;
                int new_ind = q.peek().ind-mini; // for keeping in bound and not crossing limits
                q.remove();
                if(node.left != null){
                    q.add(new Data(node.left, new_ind*2+1));
                }
                if(node.right != null){
                    q.add(new Data(node.right, new_ind*2+2));
                }
            }
            max_width = Math.max(max_width, last-first+1);
        }
        return max_width;
    }
}