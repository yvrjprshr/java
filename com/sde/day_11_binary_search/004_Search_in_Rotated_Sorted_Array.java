package com.sde.day_11_binary_search;

class Solution {
    public int search(int[] nums, int target) {
        int left = 0;
        int right = nums.length-1;
        while(right-left>1){
            int mid=left+(right-left)/2;
            if(nums[left]<nums[right]){
                if(nums[mid]<target){
                    left = mid;
                }else{
                    right = mid;
                }
            }else{
                if(nums[left] < nums[mid]){
                    if(nums[left]<=target && nums[mid]>=target){
                        right = mid;
                    }else{
                        left = mid;
                    }
                }else{
                    if(nums[mid]<=target && nums[right]>=target){
                        left = mid;
                    }else{
                        right = mid;
                    }
                }
            }
        }
        if(nums[left] == target) return left;
        if(nums[right]==target) return right;
        return -1;
    }
}