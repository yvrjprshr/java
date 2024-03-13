package com.sde.day_20_binary_search_tree;

import java.util.*;

class Node {
    public int val;
    public Node left;
    public Node right;
    public Node next;

    public Node() {}
    
    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, Node _left, Node _right, Node _next) {
        val = _val;
        left = _left;
        right = _right;
        next = _next;
    }
};


class Solution {
    public Node connect(Node root) {
        
        if(root == null) return root;
        
        List<List<Node>> levels = new ArrayList<>();
        
        Queue<Node>q = new LinkedList<>();
        q.add(root);
        
        while(!q.isEmpty()){
            int sz = q.size();
            List<Node> lst = new ArrayList<>();
            for(int i=0; i<sz; i++){
                Node temp = q.poll();
                lst.add(temp);
                if(temp.left != null){
                    q.add(temp.left);
                }
                if(temp.right != null){
                    q.add(temp.right);
                }
            }
            levels.add(lst);
        }
        
        for(int i=0; i<levels.size(); i++){
            if(levels.get(i).size()>1){
                for(int j=0; j<levels.get(i).size(); j++){
                    if(j < levels.get(i).size()-1){
                        levels.get(i).get(j).next = levels.get(i).get(j+1);
                    }
                }
            }
        }
        
        return root;
    }
}   