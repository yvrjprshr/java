package com.sde.day_11_binary_search;

class Solution {
    public static int countBig(int matrix[][], int num){
        int cnt = 0;
        for(int i=0; i<matrix.length; i++){
            int left = -1, right = matrix[i].length;
            while(right-left>1){
                int mid = left + (right-left)/2;
                if(matrix[i][mid]<num){
                    left = mid;
                }else{
                    right = mid;
                }
            }
            cnt += (matrix[i].length-right);
        }
        return cnt;
    }
    public static int findMedian(int matrix[][], int m, int n) {
        // Write your code here
        int mini = Integer.MAX_VALUE, maxi = Integer.MIN_VALUE;
        for(int i=0;i<m;i++){
            mini = Math.min(mini, matrix[i][0]);
            maxi = Math.max(maxi, matrix[i][n-1]);
        }
        while(maxi-mini>1){
            int mid = mini+(maxi-mini)/2;
            int cnt = countBig(matrix, mid);
            if(cnt <= ((m*n)/2)){
                maxi = mid;
            }else{
                mini = mid;
            }
        }
        return mini;
    }
}