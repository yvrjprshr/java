package com.sde.day_7_Linked_List_And_Arrays;

class Solution {
    public int trap(int[] height) {
        int n = height.length;
        
        int l = 0, r = n-1;
        int leftMax = 0, rightMax = 0;
        int ans = 0;
        
        while(l <= r){
            if(height[l] <= height[r]){
                if(height[l] > leftMax){
                    leftMax = height[l];
                }else{
                    ans += leftMax - height[l]; 
                }
                l++;
            }else{
                if(height[r] > rightMax){
                    rightMax = height[r];
                }else{
                    ans += rightMax-height[r];
                }
                r--;
            }
        }
        
        return ans;
    }
}