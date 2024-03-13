package com.sde.day_18_binary_tree_part_2;

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

// using dfs
class Solution {
    public int maxDepth(TreeNode root) {
        if(root == null) return 0;
        int left_subtree = maxDepth(root.left);
        int right_subtree = maxDepth(root.right);
        return 1 + Math.max(left_subtree, right_subtree);
    }
}

// using bfs
class Solution1 {
    public int maxDepth(TreeNode root) {
        int level = 0;
        Queue<TreeNode> q = new LinkedList<>();
        if(root == null) return level;
        q.add(root);
        while(!q.isEmpty()){
            int sz = q.size();
            for(int i=0; i<sz; i++){
                TreeNode node = q.poll();
                if(node.left!=null)q.add(node.left);
                if(node.right!=null)q.add(node.right);
            }
            level++;
        }
        return level;
    }
}