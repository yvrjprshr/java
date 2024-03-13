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

class Solution {
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> zig_zag_levels = new ArrayList<>();
        if(root == null) return zig_zag_levels;
        Queue<TreeNode>q = new LinkedList<>();
        q.add(root);
        while(!q.isEmpty()){
            int sz = q.size();
            List<Integer> zig_zag_level = new ArrayList<>();
            for(int i=0; i<sz; i++){
                TreeNode node = q.poll();
                zig_zag_level.add(node.val);
                if(node.left != null){
                    q.add(node.left);
                }
                if(node.right != null){ 
                    q.add(node.right);
                }
            }
            zig_zag_levels.add(zig_zag_level);
        }
        for(int i=0; i<zig_zag_levels.size(); i++){
            if(i%2==1){
                Collections.reverse(zig_zag_levels.get(i));
            }
        }
        return zig_zag_levels;
    }
}