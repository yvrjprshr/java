package com.sde.day_21_binary_search_tree_2;

class TreeNode<T>
    {
        T data;
        TreeNode<T> left;
        TreeNode<T> right;

        TreeNode(T data)
        {
            this.data = data;
            left = null;
            right = null;
        }
    };

class Solution {
    public static int ans;

    public static void dfs(TreeNode<Integer> node, int X) {
        if (node == null)
            return;

        if (node.data <= X) {
            ans = node.data;
            dfs(node.right, X);
        } else if (node.data > X) {
            dfs(node.left, X);
        }
    }

    public static int floorInBST(TreeNode<Integer> root, int X) {
        // Write your code here.
        dfs(root, X);
        return ans;
    }
}