package com.sde.day23_graphs;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

class Solution {
    class Node{
        int node;
        int color;
        public Node(int node, int color){
            this.node = node;
            this.color = color;
        }
    }
    
    public boolean bfs(int x, int graph[][], int color[]){
        Queue<Node> q = new LinkedList<>();
        color[x]=0;
        q.add(new Node(x, 0));
        
        while(!q.isEmpty()){
            int sz = q.size();
            for(int i = 0; i < sz; i++){
                Node nd = q.poll();
                int node = nd.node;
                int col = nd.color;
                for(int e: graph[node]){
                    if(color[e]==-1){
                        if(col == 0){
                            color[e]=1;
                            q.add(new Node(e, 1));
                        }else{
                            color[e]=0;
                            q.add(new Node(e, 0));
                        }
                    }else if(color[e] == col){
                        return false;
                    }
                }
            }
        }
        return true;
    }
    public boolean isBipartite(int[][] graph) {
        int n = graph.length;
        int color[] = new int[n];
        Arrays.fill(color, -1);
        // -1 => uncolored
        //  0 => color 1
        //  1 => color 2
        
        for(int i=0; i<n; i++){
            if(color[i] == -1){
                boolean res = bfs(i, graph, color);
                if(res == false){
                    return false;
                }
            }
        }
        return true;
    }
}