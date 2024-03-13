package com.sde.day_17_binary_tree;

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

class Tuple {
    TreeNode node;
    int horizontal_distance;
    int vertical_distance;
    public Tuple(TreeNode node, int horizontal_distance, int vertical_distance){
        this.node = node;
        this.horizontal_distance = horizontal_distance;
        this.vertical_distance = vertical_distance;
    }
}

class Solution {
    public List<List<Integer>> verticalTraversal(TreeNode root) {
        List<List<Integer>> ans = new ArrayList<>();
        TreeMap<Integer, TreeMap<Integer, PriorityQueue<Integer>>> mp = new TreeMap<>();
        Queue<Tuple> q = new LinkedList<>();
        q.add(new Tuple(root, 0, 0));
        while(!q.isEmpty()){
            Tuple temp = q.poll();
            TreeNode node = temp.node; 
            int hori = temp.horizontal_distance;
            int vert = temp.vertical_distance; 
            
            if(mp.containsKey(hori)==false){
                mp.put(hori, new TreeMap<>());
            }
            if(mp.get(hori).containsKey(vert)==false){
                mp.get(hori).put(vert, new PriorityQueue<>());
            }
            mp.get(hori).get(vert).offer(node.val); 
            
            if(node.left != null){
                q.add(new Tuple(node.left, hori-1, vert+1));
            }
            
            if(node.right != null){
                q.add(new Tuple(node.right, hori+1, vert+1));
            }
        }
        
        mp.forEach(
            (k, v)->{
                List<Integer> temp = new ArrayList<>();
                v.forEach(
                    (kk, vv)->{
                        while(!vv.isEmpty()){
                            temp.add(vv.poll());
                        }
                    }
                );
                ans.add(temp);
            }
        );
        return ans;
    }
}
