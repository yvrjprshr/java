package com.sde.day_17_binary_tree;

import java.util.*;

class Node{
    int data;
    Node left;
    Node right;
    Node(int data){
        this.data = data;
        left=null;
        right=null;
    }
}


class Solution
{
    //Function to return a list of nodes visible from the top view 
    //from left to right in Binary Tree.
    static class Data{
        Node node;
        int pos;
        public Data(Node node, int pos){
            this.node = node;
            this.pos = pos;
        }
    }
    static ArrayList<Integer> topView(Node root)
    {
        // add your code
        Map<Integer, Node> mp = new TreeMap<>();
        ArrayList<Integer> ans = new ArrayList<>();
        Queue<Data> q = new LinkedList<>();
        q.add(new Data(root, 0));
        while(!q.isEmpty()){
            Data data = q.poll();
            Node node = data.node;
            int pos = data.pos;
            if(mp.get(pos) == null){
                mp.put(pos, node);
            }
            
            if(node.left != null){
                q.add(new Data(node.left, pos-1));
            }
            
            if(node.right != null){
                q.add(new Data(node.right, pos+1));
            }
        }
        
        mp.forEach((k, v)->{
           ans.add(v.data); 
        });
        return ans;
    }
}