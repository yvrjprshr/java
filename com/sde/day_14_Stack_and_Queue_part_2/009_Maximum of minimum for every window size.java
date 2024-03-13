package com.sde.day_14_Stack_and_Queue_part_2;

import java.util.* ;

class Solution {
    public static int[] maxMinWindow(int[] a, int n) {
        // Write your code here
        int left[] = new int[n];
        int right[] = new int[n];
        int ans[] = new int[n];

        Stack<Integer> stack = new Stack<>();
        for(int i=0; i<n; i++){
            while(!stack.isEmpty() && a[stack.peek()] >= a[i]) stack.pop();
            if(stack.isEmpty()) left[i] = -1;
            else left[i] = stack.peek();
            stack.push(i);
        }

        stack = new Stack<>();
        for(int i=n-1; i>=0; i--){
            while(!stack.isEmpty() && a[stack.peek()] >= a[i]) stack.pop();
            if(stack.isEmpty()) right[i] = n;
            else right[i] = stack.peek();
            stack.push(i);
        }

        int temp_ans[]=new int[n+1];
        Arrays.fill(temp_ans, Integer.MIN_VALUE);
        for(int i=0; i<n; i++){
            int len = right[i]-left[i]-1;
            temp_ans[len] = Math.max(temp_ans[len], a[i]);
        }

        for(int i=n-1; i>=0; i--){
            ans[i] = temp_ans[i+1];
            if(i<n-1) ans[i] = Math.max(ans[i], ans[i+1]);
        }

        return ans;
    }
}