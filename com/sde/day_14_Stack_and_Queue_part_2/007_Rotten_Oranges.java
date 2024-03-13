package com.sde.day_14_Stack_and_Queue_part_2;

import java.util.*;

class Solution {
    public int orangesRotting(int[][] grid) {
        int rows = grid.length, cols = grid[0].length;
        Queue<int[]> q = new LinkedList<>();
        int cnt_oranges = 0;
        for(int i=0;i<grid.length;i++){
            for(int j=0;j<grid[0].length;j++){
                if(grid[i][j]==2){
                    q.add(new int[]{i, j, 0});
                }
                if(grid[i][j]!=0){
                    cnt_oranges++;
                }
            }
        }
        
        int minutes = 0;
        int cnt = 0;
        while(!q.isEmpty()){
            int sz = q.size();
            cnt += sz;
            for(int i=0; i<sz; i++){
                int temp[] = q.poll();
            
                int a = temp[0];
                int b = temp[1];
                int k = temp[2];

                int dir[][] = new int[][]{{-1,0},{1,0},{0,1},{0,-1}};

                for(int j=0; j<dir.length; j++){
                    int na = a+dir[j][0];
                    int nb = b+dir[j][1];
                    if(na >= 0 && na < rows && nb >= 0 && nb < cols){
                        if(grid[na][nb]==1){
                            grid[na][nb]=2;
                            q.add(new int[]{na,nb,k+1});
                        }
                    }
                }
            }
            if(q.size()!=0)minutes++;
        }
        return cnt == cnt_oranges ? minutes : -1;
    }
}