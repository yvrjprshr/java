package com.sde.day_3_arrays_3;

class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int left = -1;
        int right = matrix.length;
        
        while(right-left > 1){
            int mid = (left+right)/2;
            
            if(matrix[mid][0] > target){
                right = mid;
            }else{
                left = mid;
            }
        }
        
        int row = left;
        
        if(row < 0 || row >= matrix.length){
            return false;
        }
        
        left = 0; right = matrix[row].length;
        
        while(right-left > 1){
            int mid = (left+right)/2;
            
            if(matrix[row][mid] <= target){
                left = mid;
            }else{
                right = mid;
            }
        }
        
        int col = left;
        
        if(row >= 0 && col >= 0 && row < matrix.length && col < matrix[0].length){
            return matrix[row][col] == target ? true : false;
        }
        
        return false;
    }
}