package com.sde.day23_graphs;
import java.util.*;

class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        int ind[] = new int[numCourses];
        List<List<Integer>>lst = new ArrayList<>();
        for(int i=0;i<numCourses;i++){
            lst.add(new ArrayList<>());
        }
        for(int i=0; i<prerequisites.length; i++){
            int u=prerequisites[i][0];
            int v=prerequisites[i][1];
            lst.get(u).add(v);
            ind[v]++;
        }
        Queue<Integer>q=new LinkedList<>();
        int cnt = 0;
        for(int i=0;i<ind.length;i++){
            if(ind[i]==0){q.add(i);cnt++;}
        }
        if(q.isEmpty()){return false;}
        while(!q.isEmpty()){
            int node = q.poll();
            for(Integer adj_node: lst.get(node)){
                ind[adj_node]--;
                if(ind[adj_node]==0){
                    q.add(adj_node);
                    cnt++;
                }
            }
        }
        if(cnt==numCourses)return true;
        return false;
    }
}