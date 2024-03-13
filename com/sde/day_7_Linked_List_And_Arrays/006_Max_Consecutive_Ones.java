package com.sde.day_7_Linked_List_And_Arrays;

class Solution {
    public int findMaxConsecutiveOnes(int[] nums) {
        int maxi = 0;
        int currCnt = 0;
        int i = 0;
        int n = nums.length;
        
        while(i < n){
            if(nums[i] == 1){
                if(i>0 && nums[i] == nums[i-1]){
                    currCnt++;
                }else{
                    currCnt = 1;
                }
                maxi = Math.max(maxi, currCnt);
            }else{
                currCnt = 0;
            }
            i++;
        }
        
        return maxi;
    }
}