package com.sde.day_22_binary_trees_miscellaneous;

class Solution {
    
    public boolean isSafe(int i, int j, int image[][]){
        int m = image.length;
        int n = image[0].length;
        
        if(i<0 || j<0 || i>=m || j>=n){
            return false;
        }
        
        return true;
    }
    
    public void dfs(int [][] image, int vis[][], int prev_color, int sr, int sc, int color){
        int dir[][] = new int [][]{{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
        
        vis[sr][sc]=1;
        
        if(image[sr][sc] == prev_color){
            image[sr][sc] = color;
        }
        
        for(int i=0; i<dir.length; i++){
            int nr = dir[i][0] + sr;
            int nc = dir[i][1] + sc;
            if(isSafe(nr, nc, image) && image[nr][nc]==prev_color){
                if(vis[nr][nc]==0){
                    dfs(image, vis, prev_color, nr, nc, color);
                }
            }
        }
    }
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        int vis[][]=new int[image.length][image[0].length];
        dfs(image, vis, image[sr][sc], sr, sc, color);
        return image;
    }
}