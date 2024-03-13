package com.sde.day_18_binary_tree_part_2;

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
    public int diameterOfBinaryTree(TreeNode root) {
        int max_diameter[] = new int[1];
        height(root, max_diameter);
        return max_diameter[0];
    }
    public int height(TreeNode node, int[] max_diameter){
        if(node == null) return 0;
        int lh = height(node.left, max_diameter);
        int rh = height(node.right, max_diameter);
        max_diameter[0]=Math.max(max_diameter[0], lh+rh);
        return 1+Math.max(lh, rh);
    }
}