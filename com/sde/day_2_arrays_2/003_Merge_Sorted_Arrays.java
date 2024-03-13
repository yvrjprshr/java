package com.sde.day_2_arrays_2;

class Solution {
    public void swap(int nums[], int p, int q){
        int temp = nums[p];
        nums[q] = nums[p];
        nums[p] = temp;
    }
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int pt1 = m-1;
        int pt2 = n-1;
        int pt3 = m+n-1;
        
        while(pt1 >= 0 && pt2 >= 0){
            if(nums1[pt1] > nums2[pt2]){
                swap(nums1, pt1, pt3);
                pt1--;
                pt3--;
            }else{
                nums1[pt3] = nums2[pt2];
                pt2--;
                pt3--;
            }
        }
        
        while(pt2 >= 0){
            nums1[pt3] = nums2[pt2];
            pt2--;
            pt3--;
        }
    }
}