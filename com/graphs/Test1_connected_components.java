package com.graphs;

public class Test1_connected_components {
    public int countConnectedComponents(int n, int [][] edges) {
		boolean vis[] = new boolean[n];
		int components = 0;
		for(int i=0; i<n; i++) {
			if(vis[i]==false) {
				components++;
//				dfs(i, vis, edges);
			}
		}
		return components;
	}
}
