package com.sde.day_7_Linked_List_And_Arrays;

class Solution {
    public int removeDuplicates(int[] nums) {
        int i = 0, j = 1, n = nums.length;
        while(j < n){
             if(nums[j-1] != nums[j]){
                 i++;
                 nums[i] = nums[j];
             }
            j++;
        }
        return i+1;
    }
}