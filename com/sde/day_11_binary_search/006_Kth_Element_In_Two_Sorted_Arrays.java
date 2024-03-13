package com.sde.day_11_binary_search;

class Solution {
    public long kthElement( int arr1[], int arr2[], int n, int m, int k) {
        if(n > m){
            return kthElement(arr2, arr1, m, n, k);
        }
        
        int left = Math.max(0, k-m), right = Math.min(n, k);
        
        while(left <= right){
            int mid1 = left + (right-left)/2;
            int mid2 = k-mid1;
            
            int l1 = mid1 <= 0 ? Integer.MIN_VALUE : arr1[mid1-1];
            int r1 = mid1 >= n ? Integer.MAX_VALUE : arr1[mid1];
            
            int l2 = mid2 <= 0 ? Integer.MIN_VALUE : arr2[mid2-1];
            int r2 = mid2 >= m ? Integer.MAX_VALUE : arr2[mid2];
            
            if(l1 <= r2 && l2 <= r1){
                return Math.max(l1, l2);
            }
            
            if(l1 > r2){
                right = mid1-1;
            }else{
                left = mid1+1;
            }
        }
        
        return -1;
    }
}
