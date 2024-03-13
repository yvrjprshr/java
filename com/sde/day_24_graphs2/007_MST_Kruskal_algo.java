package com.sde.day_24_graphs2;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

class DisjointSet{
    List<Integer> parent = new ArrayList<>();
    List<Integer> rank = new ArrayList<>();
    List<Integer> size = new ArrayList<>();

    public DisjointSet(int n){
        for(int i=0;i<=n;i++){
            rank.add(0);
            parent.add(i);
            size.add(1);
        }
    }

    public int findParent(int node){
        if(parent.get(node) == node) return node;
        int par = findParent(parent.get(node));
        parent.set(node, par);
        return parent.get(node);
    }

    public void unionByRank(int u, int v){
        int par_u = findParent(u);
        int par_v = findParent(v);
        if(par_u == par_v){return;}
        if(rank.get(par_u) < rank.get(par_v)){
            parent.set(par_u, par_v);
        }else if(rank.get(par_v) < rank.get(par_u)){
            parent.set(par_v, par_u);
        }else{
            parent.set(par_v, par_u);
            rank.set(par_u, rank.get(par_u)+1);
        }
    }

    public void unionBySize(int u, int v){
        int par_u = findParent(u);
        int par_v = findParent(v);
        if(par_u == par_v) return;

        if(size.get(par_u) < size.get(par_v)){
            parent.set(par_u, par_v);
            size.set(par_v, size.get(par_v)+size.get(par_u));
        }else{
            parent.set(par_v, par_u);
            size.set(par_u, size.get(par_u)+size.get(par_v));
        }
    }
}

class Edge implements Comparable<Edge>{
    int src, dest, weight;
    Edge(int src, int dest, int weight){
        this.src = src;
        this.dest = dest;
        this.weight = weight;
    }
    public int compareTo(Edge compareEdge){
        return this.weight - compareEdge.weight;
    }
};

class Kruskal_Algo{
    public int spanningTree(int V, ArrayList<ArrayList<ArrayList<Integer>>> adj){
        List<Edge> edges = new ArrayList<>();
        
        for (int i = 0; i < V; i++) {
            for (int j = 0; j < adj.get(i).size(); j++) {
                int adjNode = adj.get(i).get(j).get(0);
                int wt = adj.get(i).get(j).get(1);
                int node = i;
                Edge temp = new Edge(node, adjNode, wt);
                edges.add(temp);
            }
        }

        Collections.sort(edges);
        
        int mstWt = 0;
        DisjointSet ds = new DisjointSet(V);

        for(int i=0; i<edges.size(); i++){
            int wt = edges.get(i).weight;
            int u = edges.get(i).src;
            int v = edges.get(i).dest;

            if(ds.findParent(u) != ds.findParent(v)){
                mstWt += wt;
                ds.unionBySize(u, v);
            }
        }
        return mstWt;
    }

    public static void main(String[] args) {
        int V = 5;
        ArrayList<ArrayList<ArrayList<Integer>>> adj = new ArrayList<ArrayList<ArrayList<Integer>>>();
        int[][] edges =  {{0, 1, 2}, {0, 2, 1}, {1, 2, 1}, {2, 3, 2}, {3, 4, 1}, {4, 2, 2}};

        for(int i=0;i<V;i++){
            adj.add(new ArrayList<>());
        }

        for(int i=0;i<V;i++){
            int u = edges[i][0];
            int v = edges[i][1];
            int w = edges[i][2];
            ArrayList<Integer> temp1 = new ArrayList<>();
            temp1.add(v);
            temp1.add(w);
            
            ArrayList<Integer> temp2 = new ArrayList<>();
            temp1.add(u);
            temp1.add(w);

            adj.get(u).add(temp1);
            adj.get(v).add(temp2);
        }

        Kruskal_Algo obj = new Kruskal_Algo();
        int mst_weight = obj.spanningTree(V, adj);
        System.out.println("The sum of all the edge weights: "+mst_weight);
    }
}