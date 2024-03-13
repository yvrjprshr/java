package com.sde.day_17_binary_tree;

import java.util.*;

class Node{
    int data;
    Node left, right;
    Node(int data){
        this.data = data;
        left = null;
        right = null;
    }
}

class Solution{
    static boolean getPath(Node root, ArrayList<Integer> ans, int x){
        if(root == null)return false;

        ans.add(root.data);

        if(root.data == x){
            return true;
        }

        if(getPath(root.left, ans, x) || getPath(root.right, ans, x)){
            return true;
        }

        ans.remove(ans.size()-1);
        return false;
    }
    public static void main(String[] args) {
        Node root = new Node(1);
        root.left = new Node(2);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        root.left.right.left = new Node(6);
        root.left.right.right = new Node(7);
        root.right = new Node(3);

        ArrayList < Integer > arr = new ArrayList < > ();

        getPath(root, arr, 7);

        System.out.print("The path is ");
        for (int it: arr) {
            System.out.print(it + " ");
        }
    }
}