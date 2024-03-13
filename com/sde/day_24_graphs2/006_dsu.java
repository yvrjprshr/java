package com.sde.day_24_graphs2;

import java.util.*;
 
class DSU{
 
    List<Integer> rank = new ArrayList<>();
    List<Integer> parent = new ArrayList<>();
    List<Integer> size = new ArrayList<>();
 
    public DSU(int n){
        for(int i=0; i<=n; i++){
            rank.add(0);
            size.add(1);
            parent.add(i);
        }
    }
 
    public int findParent(int node){
        if(parent.get(node) == node){
            return node;
        }
        int x = findParent(parent.get(node));
        parent.set(node, x); // path compression
        return parent.get(node);
    }
 
    public void unionByRank(int u, int v){
        int par_u = findParent(u);
        int par_v = findParent(v);
        
        if(findParent(u) == findParent(v)) return;
 
        if(rank.get(par_u) < rank.get(par_v)){
            parent.set(par_u, par_v);
        }
        else if(rank.get(par_v) < rank.get(par_u)){
            parent.set(par_v, par_u);
        }
        else{
            parent.set(par_v, par_u);
            int rank_u = rank.get(par_u);
            rank.set(par_u, rank_u+1);
        }
    }
 
    public void unionBySize(int u, int v){
        int par_u = findParent(u);
        int par_v = findParent(v);
        if(par_u == par_v) return;
 
        if(size.get(par_u) < size.get(par_v)){
            parent.set(par_u, par_v);
            size.set(par_v, size.get(par_v) + size.get(par_u));
        }else {
            parent.set(par_v, par_u);
            size.set(par_u, size.get(par_v)+size.get(par_u));
        }
    }
 
    public static void main(String[] args) {
        DSU dsu = new DSU(7);
        
        dsu.unionByRank(1, 2);
        dsu.unionByRank(2, 3);
        dsu.unionByRank(4, 5);
        dsu.unionByRank(6, 7);
        dsu.unionByRank(5, 6);
 
        if(dsu.findParent(3) == dsu.findParent(1)){
            System.out.println("same");
        }else{
            System.out.println("Not same");
        }
    }
}