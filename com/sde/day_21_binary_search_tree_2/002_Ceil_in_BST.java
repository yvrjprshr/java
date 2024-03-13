package com.sde.day_21_binary_search_tree_2;

class TreeNode<T> {
    T data;
    TreeNode<T> left;
    TreeNode<T> right;

    TreeNode(T data) {
        this.data = data;
        left = null;
        right = null;
    }
};

class Solution {

    public static int ans;

    public static int dfs(TreeNode<Integer> node, int x, int ans) {
        if (node == null)
            return ans;

        if (node.data < x) {
            return dfs(node.right, x, ans);
        }

        if (node.data >= x) {
            ans = node.data;
            return dfs(node.left, x, ans);
        }

        return ans;
    }

    public static int findCeil(TreeNode<Integer> node, int x) {

        // Write your code here
        return dfs(node, x, -1);
        // return ans;
    }
}
