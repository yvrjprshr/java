package com.sde.day23_graphs;
import java.util.ArrayList;
import java.util.Stack;

class Solution {

    public void findTopo(int node, int vis[], Stack<Integer> stk, ArrayList<ArrayList<Integer>> adj){
        vis[node]=1;
        for(Integer adj_node: adj.get(node)){
            if(vis[adj_node]==0){
                findTopo(adj_node, vis, stk, adj);
            }
        }
        stk.push(node);
    }

    public int [] topoSort(int V, ArrayList<ArrayList<Integer>> adj){
        Stack<Integer> stk = new Stack<>();
        int vis[] = new int[V];

        for(int i=0;i<V;i++){
            if(vis[i]==0){
                findTopo(i, vis, stk, adj);
            }
        }

        int store[] = new int[V];
        int i=0;
        while (!stk.empty()) {
            int node = stk.pop();
            store[i]=node;
            i++;
        }
        return store;
    } 

    public static void main(String[] args) {
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        int n = 6;
        for (int i = 0; i < n; i++) {
            ArrayList<Integer> arr = new ArrayList<>();
            adj.add(arr);
        }

        adj.get(5).add(2);
        adj.get(5).add(0);
        adj.get(4).add(0);
        adj.get(4).add(1);
        adj.get(2).add(3);
        adj.get(3).add(1);

        Solution obj = new Solution();
        int ans[] = obj.topoSort(n, adj);
        System.out.println("Toposort of the given graph is: ");
        for(int i=0;i<n;i++){
            System.out.println(ans[i]+" ");
        }
    }
}