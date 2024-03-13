package com.sde.day_24_graphs2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;

class Solution
{
    //Function to find the shortest distance of all the vertices
    //from the source vertex S.
    static class Node{
        int node;
        int dist;
        public Node(int a, int b){
            node = a;
            dist = b;
        }
    }
    static int[] dijkstra(int V, ArrayList<ArrayList<ArrayList<Integer>>> adj, int S)
    {
        // Write your code here
        int distance[] = new int [V];
        Arrays.fill(distance, Integer.MAX_VALUE);
        distance[S]=0;
        PriorityQueue<Node> pq = new PriorityQueue<>((a, b)-> a.dist-b.dist);
        pq.add(new Node(S, 0));
        distance[S]=0;
        while(!pq.isEmpty()){
            Node x = pq.poll();
            int node = x.node;
            // int dist = x.dist;
            for(ArrayList<Integer> adj_node_data: adj.get(node)){
                int adj_node = adj_node_data.get(0);
                int adj_node_dist = adj_node_data.get(1);
                if(distance[node] + adj_node_dist < distance[adj_node]){
                    distance[adj_node] = distance[node] + adj_node_dist;
                    pq.add(new Node(adj_node, distance[adj_node]));
                }
            }
        }
        
        return distance;
    }
}