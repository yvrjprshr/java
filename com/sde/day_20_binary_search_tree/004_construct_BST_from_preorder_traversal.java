package com.sde.day_20_binary_search_tree;


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
    public TreeNode cons(int preorder[], int start, int end){
        if(start > end) return null;
        TreeNode root = new TreeNode(preorder[start]);
        int brk = start;
        while(brk <= end){
            if(preorder[brk]>preorder[start])break;
            brk++;
        }
        if(brk == start){
            root.left = null;
            root.right = cons(preorder, start+1, end);
        }else if(brk == end+1){
            root.left = cons(preorder, start+1, end);
            root.right = null;
        }else{
            root.left = cons(preorder, start+1, brk-1);
            root.right = cons(preorder, brk, end);
        }
        
        return root;
    }
    public TreeNode bstFromPreorder(int[] preorder) {
        return cons(preorder, 0, preorder.length-1);
    }
}