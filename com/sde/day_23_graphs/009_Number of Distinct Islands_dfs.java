package com.sde.day23_graphs;

class Solution {
    
    public boolean isValid(int i, int j, char[][]grid){
        int m = grid.length;
        int n = grid[0].length;
        if(i>=0 && j>=0 && i<m && j<n) return true;
        return false;
    }
    
    public void dfs(int row, int col, char[][] grid){
        grid[row][col]='0';
        int dir[][] = new int[][]{{1,0},{-1,0},{0,1},{0,-1}};
        for(int a[]: dir){
            int nr = row+a[0];
            int nc = col+a[1];
            if(isValid(nr, nc, grid) && grid[nr][nc]=='1'){
                dfs(nr, nc, grid);
                
            }
        }
    }

    public int numIslands(char[][] grid) {
        int cnt = 0;
        int m=grid.length;int n=grid[0].length;
        for(int i=0; i<m; i++){
            for(int j=0; j<n; j++){
                if(grid[i][j] == '1'){
                    dfs(i, j, grid);
                    cnt++;
                }
            }
        }
        return cnt;
    }   
}