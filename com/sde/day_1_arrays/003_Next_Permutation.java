package com.sde.day_1_arrays;

import java.util.*;

class Solution {
    public void nextPermutation(int[] nums) {
        int n = nums.length;
        int x = -1;
        for(int i=n-1; i>0; i--){
            if(nums[i-1]<nums[i]){
                x = i-1;
                break;
            }
        }
        if(x == -1){
            int i=0,j=n-1;
            while(i<j){
                int temp = nums[i];
                nums[i] = nums[j];
                nums[j] = temp;
                i++;j--;
            }
        }else{
            int pt = n-1;
            while(pt>x){
                if(nums[pt] > nums[x]){
                    break;
                }
                pt--;
            }
            int temp = nums[x];
            nums[x] = nums[pt];
            nums[pt] = temp;
            
            Arrays.sort(nums, x+1, n);
        }
    }
}