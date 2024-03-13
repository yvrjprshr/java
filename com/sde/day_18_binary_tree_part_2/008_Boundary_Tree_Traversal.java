package com.sde.day_18_binary_tree_part_2;

import java.util.ArrayList;
import java.util.List;

class TreeNode {
    int data;
    TreeNode left;
    TreeNode right;

    TreeNode(int data) {
        this.data = data;
        this.left = null;
        this.right = null;
    }
}

class Solution {
    public static boolean isLeafNode(TreeNode root){
        if(root.left == null && root.right == null){
            return true;
        }
        return false;
    }

    public static void addLeftBoundary(TreeNode root, List<Integer> ans){
        TreeNode node = root.left;
        while(node!=null){
            if(isLeafNode(node) == false) ans.add(node.data);
            if(node.left != null) node = node.left;
            else node = node.right;
        }
    }

    public static void addRightBoundary(TreeNode root, List<Integer> ans){
        ArrayList<Integer> temp = new ArrayList<>();
        TreeNode node = root.right;
        while(node != null){
            if(isLeafNode(node) == false) temp.add(node.data);
            if(node.right != null) node = node.right;
            else node = node.left;
        }

        for(int i = temp.size()-1; i >= 0; i--){
            ans.add(temp.get(i));
        }
    }

    public static void addLeafNodes(TreeNode root, List<Integer> ans){
        if(root == null) return;

        if(isLeafNode(root)){
            ans.add(root.data);
            return;
        }

        addLeafNodes(root.left, ans);
        addLeafNodes(root.right, ans);
    }
    public static List<Integer> traverseBoundary(TreeNode root){
        // Write your code here.
        
        /*
        Steps
            - add left boundary excluding root and leaf nodes
            - add leaves
            - add add right boundary excluding root and leaf nodes
        */
        List<Integer> ans = new ArrayList<>();
        if(isLeafNode(root) == false) ans.add(root.data);
        addLeftBoundary(root, ans);
        addLeafNodes(root, ans);
        addRightBoundary(root, ans);
        return ans;
    }
}