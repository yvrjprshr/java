package com.sde.day_20_binary_search_tree;

class Solution {
    
    class Node{
        int data;
        Node left;
        Node right;
    }

    static Node pre, suc;

    public static void trav(Node root, int key) {
        if (root == null)
            return;
        if (root.data < key) {
            pre = root;
            trav(root.right, key);
        } else if (root.data > key) {
            suc = root;
            trav(root.left, key);
        } else {
            trav(root.left, key);
            trav(root.right, key);
        }
    }

    public static void findPreSuc(Node root, int key) {
        // code here.

        /*
         * There are two static nodes defined above pre(representing predecessor) and
         * suc(representing successor) as follows:
         * static Node pre=null,suc=null
         * You need to update these both.
         * And the data inside these classes will be printed automatically by the driver
         * code.
         */
        pre = null;
        suc = null;
        trav(root, key);
    }
}
