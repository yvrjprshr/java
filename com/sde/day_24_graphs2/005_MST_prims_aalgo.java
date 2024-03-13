package com.sde.day_24_graphs2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;

class Pair{
    int node;
    int distance;
    public Pair(int distance, int node){
        this.distance = distance;
        this.node = node;
    }
}

class Solution{
    static int minimum_spanning_tree(int V, ArrayList<ArrayList<ArrayList<Integer>>> adj){
        PriorityQueue<Pair>pq = new PriorityQueue<Pair>((x,y) -> x.distance-y.distance);
        int[] vis = new int[V];
        pq.add(new Pair(0, 0));
        int sum = 0;
        while(pq.size()>0){
            int wt = pq.peek().distance;
            int node = pq.peek().node;
            pq.remove();

            if(vis[node] == 1) continue;

            vis[node] = 1;
            sum += wt;

            for(int i=0; i<adj.get(node).size();i++){
                int edgeWeight = adj.get(node).get(i).get(1);
                int adj_node = adj.get(node).get(i).get(0);
                if(vis[adj_node] == 0){
                    pq.add(new Pair(edgeWeight, adj_node));
                }
            }
        }
        return sum; 
    }
    public static void main(String[] args) {
        int V = 5;
        ArrayList<ArrayList<ArrayList<Integer>>> adj = new ArrayList<ArrayList<ArrayList<Integer>>>();
        int[][] edges =  {{0, 1, 2}, {0, 2, 1}, {1, 2, 1}, {2, 3, 2}, {3, 4, 1}, {4, 2, 2}};

        for (int i = 0; i < V; i++) {
            adj.add(new ArrayList<ArrayList<Integer>>());
        }
        for(int i=0; i<6; i++){
            int u = edges[i][0];
            int v = edges[i][1];
            int w = edges[i][2];

            adj.get(u).add(new ArrayList<>(Arrays.asList(v,w)));
            adj.get(v).add(new ArrayList<>(Arrays.asList(u,w)));
        }

        // Solution obj = new Solution();
        int sum = Solution.minimum_spanning_tree(V, adj);       
        System.out.println("The sum of all the edge weights: "+sum); 
       }
}