package com.sde.day_14_Stack_and_Queue_part_2;

import java.util.*;

class Solution {
    public int largestRectangleArea(int[] heights) {
        Stack<int[]> stack = new Stack<>();
        
        int res = Integer.MIN_VALUE;
        
        for(int i = 0; i < heights.length; i++){
            int start_from = i;
            
            while(!stack.isEmpty() && stack.peek()[0] > heights[i]){
                int height = stack.peek()[0];
                int ind = stack.peek()[1];
                int width = (i-1) - ind + 1;
                stack.pop();
                res = Math.max(res, height * width);
                start_from = ind;
            }
            
            stack.push(new int[]{heights[i], start_from});
        }
        
        int n = heights.length;
        
        while(!stack.isEmpty()){
            int height = stack.peek()[0];
            int ind = stack.peek()[1];
            int width = n-ind;
            stack.pop();
            res = Math.max(res, height*width);
        }
        
        return res;
    }
}