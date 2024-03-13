package com.sde.day_17_binary_tree;

import java.util.*;

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode() {
    }

    TreeNode(int val) {
        this.val = val;
    }

    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}


class Solution
{
    class Data{
        TreeNode n;
        int pos;
        public Data(TreeNode n, int pos){
            this.n = n;
            this.pos = pos;
        }
    }
    public ArrayList <Integer> bottomView(TreeNode root)
    {
        // Code here
        Map<Integer, TreeNode> mp = new TreeMap<>();
        ArrayList<Integer> ans = new ArrayList<>();
        
        if(root == null) return ans;
        
        Queue<Data>q = new LinkedList<>();
        
        q.add(new Data(root, 0));
        
        while(!q.isEmpty()){
            // int sz = q.size();
            // while(sz-->0){
                Data d = q.poll();
                mp.put(d.pos, d.n);
                if(d.n.left!=null){
                    q.add(new Data(d.n.left, d.pos-1));
                }
                if(d.n.right!=null){
                    q.add(new Data(d.n.right, d.pos+1));
                }
            // }
        }
        mp.forEach((k,v)->{
         ans.add(v.val);   
        });
        
        // Queue<Integer> q = new LinkedList<>();
        return ans;
    }
}