package com.sde.day_24_graphs2;

import java.util.ArrayList;
import java.util.Stack;

class Solution{
    /*
     * Algorithm
     * 
     * 1) Sort all the nodes according to their finishing time
     * 2) Reverse all the edges of the entire graph
     * 3) Perform the DFS and count the no. of different DFS calls to get the no. of SCC
    */

    private void dfs(int node, int vis[], ArrayList<ArrayList<Integer>> adj, Stack<Integer>st){
        vis[node]=1;
        for(int adj_node: adj.get(node)){
            if(vis[adj_node]==0){
                dfs(adj_node, vis, adj, st);
            }
        }     
        st.push(node);   
    }
    

    public void dfs3(int node, int vis[], ArrayList<ArrayList<Integer>>adjT){
        vis[node]=1;
        for(int adj_node: adjT.get(node)){
            if(vis[adj_node] == 0){
                dfs3(adj_node, vis, adjT);
            }
        }
    }

    public int kosaraju(int V, ArrayList<ArrayList<Integer>> adj){
        int vis[] = new int[V];
        Stack<Integer> st = new Stack<>();
        for(int i=0; i<V; i++){
            if(vis[i]==0){
                dfs(i, vis, adj, st);
            }
        }
        ArrayList<ArrayList<Integer>> adjT = new ArrayList<>();
        for(int i=0; i<V; i++){
            adjT.add(new ArrayList<>());
        }
        for(int i=0; i<V;i++){
            vis[i]=0;
            for(int adjc: adj.get(i)){
                adjT.get(adjc).add(i);
            }
        }
        int scc = 0;
        while(!st.isEmpty()){
            int node = st.peek();
            st.pop();
            if(vis[node] == 0){
                scc++;
                dfs3(node, vis, adjT);
            }
        }
        return scc;
    }
    public static void main(String[] args) {
        int n = 5;
        int[][] edges = {
            {1, 0}, {0, 2},
            {2, 1}, {0, 3},
            {3, 4}
        };
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < n; i++   ) {
            adj.add(new ArrayList<Integer>());
        }
        for (int i = 0; i < n; i++) {
            adj.get(edges[i][0]).add(edges[i][1]);
        } 
        Solution obj = new Solution();
        int ans = obj.kosaraju(n, adj);
        System.out.println("The number of strongly connected components is: "+ ans);
    }
}