package com.sde.day_24_graphs2;

import java.util.ArrayList;
import java.util.Arrays;

class Solution {
    static int[] bellman_ford(int V, ArrayList<ArrayList<Integer>> edges, int S) {
        // Write your code here
        
        int dist[] = new int[V];
        Arrays.fill(dist, 100000000);
        dist[S] = 0;
        
        for(int i=1; i<=V-1; i++){
            for(ArrayList<Integer> arr: edges){
                int u = arr.get(0);
                int v = arr.get(1);
                int d = arr.get(2);
                if(dist[u] + d < dist[v]){
                    dist[v] = dist[u] + d;
                }
            }
        }
        
        boolean isNegCycle = false;
        
        for(ArrayList<Integer> arr: edges){
            int u = arr.get(0);
            int v = arr.get(1);
            int d = arr.get(2);
            if(dist[u] + d < dist[v]){
                isNegCycle = true;
            }
        }
        
        if(isNegCycle){
            return new int[]{-1};    
        }
        
        return dist;
    }
}