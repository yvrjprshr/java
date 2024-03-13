package com.graphs;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

import org.w3c.dom.Node;

public class Test2_shortest_paths {
    // why we can not use dfs to find shortest path in undirected graph

    // undirected path
    // can not use dfs cuz, it visits node only once and that will not help to check
    // all paths

    // we can use bfs or dijkstra
    // bfs TC: O(v+e)
    // dijkstra TC: O(v + e log v)

    // in bfs, if found targeted node, return directly, cus we are going level wise,
    // and current level will be closest
    // use bfs to find shortest path when there is unit distance

    // https://leetcode.com/problems/01-matrix/
    // multi-source BFS
    // https://leetcode.com/problems/01-matrix/submissions/1049786796/

    class Solution {
        public int[][] updateMatrix(int[][] mat) {
            int n = mat.length;
            int m = mat[0].length;

            int ans[][] = new int[n][m];

            Queue<Integer> que = new LinkedList<>();

            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    if (mat[i][j] == 0) {
                        ans[i][j] = 0;
                        que.add(i * (m + n) + j);
                    } else {
                        ans[i][j] = -1;
                    }
                }
            }

            int level = 0;

            int dir[][] = new int[][] { { 0, 1 }, { 0, -1 }, { -1, 0 }, { 1, 0 } };

            while (!que.isEmpty()) {
                int sz = que.size();
                for (int i = 0; i < sz; i++) {
                    int cell = que.poll();
                    int curr_row = cell / (m + n);
                    int curr_col = cell % (m + n);
                    for (int j = 0; j < dir.length; j++) {
                        int next_row = curr_row + dir[j][0];
                        int next_col = curr_col + dir[j][1];
                        if (next_row >= 0 && next_col >= 0 && next_row < n && next_col < m
                                && ans[next_row][next_col] == -1) {
                            ans[next_row][next_col] = level + 1;
                            que.add(next_row * (m + n) + next_col);
                        }
                    }
                }
                level = level + 1;
                System.out.println(level);
            }
            return ans;
        }
    }

    // shortest path in a grid with obstacle elimination
    // https://leetcode.com/problems/shortest-path-in-a-grid-with-obstacles-elimination/description/
    
    class Solution2 {

        class Node {
            int a, b, c;

            public Node(int a, int b, int c) {
                this.a = a;
                this.b = b;
                this.c = c;
            }
        }

        public boolean issafe(int i, int j, int[][] grid) {
            if (i >= 0 && j >= 0 && i < grid.length && j < grid[0].length) {
                return true;
            }
            return false;
        }

        public int shortestPath(int[][] grid, int k) {

            int m = grid.length;
            int n = grid[0].length;

            if (m == 1 && n == 1) {
                return 0;
            }

            int sup[][] = new int[m][n];

            for (int i = 0; i < m; i++) {
                Arrays.fill(sup[i], -1);
            }

            int dir[][] = new int[][] { { 1, 0 }, { -1, 0 }, { 0, 1 }, { 0, -1 } };

            int level = 0;
            Queue<Node> q = new LinkedList<>();
            q.add(new Node(0, 0, k));
            sup[0][0] = k;

            while (!q.isEmpty()) {
                int sz = q.size();
                while (sz-- > 0) {
                    Node cell = q.poll();

                    for (int i = 0; i < dir.length; i++) {
                        int nc = cell.a + dir[i][0];
                        int nr = cell.b + dir[i][1];

                        if (nc == m - 1 && nr == n - 1) {
                            return level + 1;
                        }

                        if (issafe(nc, nr, grid)) {
                            if (grid[nc][nr] == 1 && cell.c > 0 && sup[nc][nr] < cell.c - 1) {
                                sup[nc][nr] = cell.c - 1;
                                q.add(new Node(nc, nr, cell.c - 1));
                            } else if (grid[nc][nr] == 0 && sup[nc][nr] < cell.c) {
                                sup[nc][nr] = cell.c;
                                q.add(new Node(nc, nr, cell.c));
                            }
                        }
                    }
                }
                level = level + 1;
            }
            return -1;
        }
    }
}
