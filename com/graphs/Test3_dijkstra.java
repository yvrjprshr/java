package com.graphs;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;

public class Test3_dijkstra {

    // https://leetcode.com/problems/network-delay-time/
    class Solution {
        class Node {
            int node;
            int dist;

            Node(int node, int dist) {
                this.node = node;
                this.dist = dist;
            }
        }

        public int networkDelayTime(int[][] times, int n, int k) {
            List<List<Node>> adj = new ArrayList<>();

            for (int i = 0; i <= n; i++) {
                adj.add(new ArrayList<>());
            }

            for (int p[] : times) {
                int u = p[0];
                int v = p[1];
                int wt = p[2];

                adj.get(u).add(new Node(v, wt));
            }

            int distance[] = new int[n + 1];
            Arrays.fill(distance, Integer.MAX_VALUE);
            Queue<Node> pq = new PriorityQueue<>((p1, p2) -> p1.dist - p2.dist);
            pq.add(new Node(k, 0));
            distance[k] = 0;
            while (!pq.isEmpty()) {
                Node nd = pq.poll();
                int node = nd.node;
                int dist = nd.dist;
                for (Node p : adj.get(node)) {
                    if (dist + p.dist < distance[p.node]) {
                        distance[p.node] = dist + p.dist;
                        pq.add(new Node(p.node, distance[p.node]));

                    }
                }
            }

            int maxi = 0;

            for (int i = 1; i <= n; i++) {
                maxi = Math.max(distance[i], maxi);
            }

            return maxi == Integer.MAX_VALUE ? -1 : maxi; // in case of connected components
        }

    }
}
