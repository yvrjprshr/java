package com.sde.day23_graphs;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

class Solution{
    class Node{
        int first;
        int second;
        public Node(int first, int second){
            this.first=first;
            this.second=second;
        }
    }

    boolean checkForCycle(ArrayList<ArrayList<Integer>> adj, int s, boolean vis[]){
        Queue<Node>q=new LinkedList<>();
        q.add(new Node(s, -1));
        vis[s]=true;

        while(!q.isEmpty()){
            Node n = q.poll();
            int node = n.first;
            int parent = n.second;
            for(Integer adj_node: adj.get(node)){
                if(vis[node]==false){
                    q.add(new Node(adj_node, node));
                    vis[node]=true;
                }else if(parent != node){
                    return true;
                }
            }
        }
        return true;
    }

    public boolean isCycle(int V, ArrayList<ArrayList<Integer>> adj){
        boolean vis[] = new boolean[V];
        Arrays.fill(vis, false);
        for(int i=0;i<V;i++){
            if(checkForCycle(adj, i, vis)==true){
                return true;
            }
        }
        return false;
    }
    public static void main(String[] args) {
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        
        for(int i=0;i<4;i++){
            adj.add(new ArrayList<>());
        }
        
        adj.get(1).add(2);
        adj.get(2).add(1);
        adj.get(2).add(3);
        adj.get(3).add(2);

        Solution obj = new Solution();
        boolean ans = obj.isCycle(4, adj);
        if(ans){
            System.out.println("1");
        }else{
            System.out.println("0");
        }
    }
}
