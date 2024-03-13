package com.sde.day_11_binary_search;

class Solution {
    public int singleNonDuplicate(int[] nums) {
        if(nums.length == 1) return nums[0];
        int left = -1, right = nums.length, n = nums.length;
        while(right-left>1){
            int mid = left + (right-left)/2;
            if(mid == 0){
                if(nums[mid]==nums[mid+1]){
                    if(((n-mid)%2)==0){
                        right = mid;
                    }else{
                        left = mid;
                    }
                }else{
                    return nums[mid];
                }
            }else if(mid == nums.length-1){
                if(nums[mid-1]==nums[mid]){
                    if(((n-mid-1)%2)==0){
                        right = mid;
                    }else{
                        left = mid;
                    }
                }else{
                    return nums[mid];
                }
            }else{
                if(nums[mid-1]==nums[mid]){
                    if(((n-mid-1)%2)==0){
                        right = mid;
                    }else{
                        left = mid;
                    }
                }else if(nums[mid]==nums[mid+1]){
                    if(((n-mid)%2)==0){
                        right = mid;
                    }else{
                        left = mid;
                    }
                }else{
                    return nums[mid];
                }
            }
        }
        return nums[left];
    }
}