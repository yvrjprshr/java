package com.sde.day_2_arrays_2;

class Solution {
    public void rotate(int[][] matrix) {
        // transpose matrix and reverse
        int m = matrix.length;
        int n = matrix[0].length;
        for(int i=0; i<m; i++){
            for(int j=i; j<n; j++){
                int x = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = x;
            }
        }
        for(int i=0; i<m; i++){
            int left = 0, right = matrix[i].length-1;
            while(left <= right){
                int temp = matrix[i][left];
                matrix[i][left] = matrix[i][right];
                matrix[i][right] = temp;
                left++; right--;
            }
        }
    }
}