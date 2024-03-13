package com.graphs;

import java.util.ArrayList;
import java.util.Scanner;

public class Test0 {
    public static void dfs(int node, int vis[], int val[], ArrayList<ArrayList<int[]>> adj) {
        vis[node] = 1;
        for (int child[] : adj.get(node)) {
            int nod = child[0];
            int wt = child[1];
            if (vis[nod] == 0) {
                val[nod] = val[node] + wt;
                dfs(nod, vis, val, adj);
            }
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int t = sc.nextInt();
        sc.nextLong();
        while (t-- > 0) {

            int nodes = sc.nextInt();
            int edges = sc.nextInt();

            ArrayList<ArrayList<int[]>> adj = new ArrayList<>();
            for(int i=0;i<=nodes;i++){
                adj.add(new ArrayList<>());
            }

            ArrayList<int[]> arr = new ArrayList<>();
            for (int i = 0; i < edges; i++) {
                int u, v, w;
                u = sc.nextInt();
                v = sc.nextInt();
                w = sc.nextInt();
                adj.get(u).add(new int[] { v, w });
                adj.get(v).add(new int[] { u, -1 * w });
                arr.add(new int[] { u, v, w });
            }
            int val[] = new int[nodes + 1];
            int vis[] = new int[nodes + 1];
            for (int i = 0; i <= nodes; i++) {
                val[i] = 0;
                vis[i] = 0;
            }
            for (int i = 1; i <= nodes; i++) {
                if (vis[i] == 0) {
                    dfs(i, vis, val, adj);
                }
            }

            boolean flag = true;
            for (int i = 0; i < arr.size(); i++) {
                int a = arr.get(i)[0];
                int b = arr.get(i)[1];
                int c = arr.get(i)[2];

                if (val[a] + c != b) {
                    flag=false;
                    break;
                }
            }
            if(flag){
                System.out.println("YES");
            }else{
                System.out.println("NO");
            }
        }
        sc.close();
    }
}
