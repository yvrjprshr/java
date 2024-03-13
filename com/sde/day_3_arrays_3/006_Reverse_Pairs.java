package com.sde.day_3_arrays_3;

class Solution {
    public int reversePairs(int[] nums) {
        return mergeSort(nums, 0, nums.length-1);
    }
    
    public int mergeSort(int nums[], int low, int high){
        int cnt = 0;
        if(low >= high) return cnt;
        int mid = (low+high)/2;
        cnt += mergeSort(nums, low, mid);
        cnt += mergeSort(nums, mid+1, high);
        cnt += countReversePairs(nums, low, mid, high);
        merge(nums, low, mid, high);
        return cnt;
    }
    
    public void merge(int nums[], int low, int mid, int high){
        int temp[] = new int[high-low+1];
        int left = low;
        int right = mid+1;
        int index = 0;
        while(left <= mid && right <= high){
            if(nums[left] <= nums[right]){
                temp[index] = nums[left];
                left++;
            }else{
                temp[index] = nums[right];
                right++;
            }
            index++;
        }
        while(left <= mid){
            temp[index] = nums[left];
            index++;left++;
        }
        while(right <= high){
            temp[index] = nums[right];
            index++; right++;
        }
        for(int i=low; i<=high; i++){
            nums[i] = temp[i-low];
        }
    }
    
    public int countReversePairs(int nums[], int low, int mid, int high){
        int cnt = 0;
        int right = mid+1;
        for(int i=low; i<= mid; i++){
            while(right <= high && nums[i] > nums[right]*2L)right++;
            cnt += (right-(mid+1));
        }
        return cnt;
    }
}