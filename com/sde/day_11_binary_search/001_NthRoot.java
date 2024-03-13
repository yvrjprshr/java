package com.sde.day_11_binary_search;

class Solution {
    public static int multiple(int num, int n){
        int ans = 1;
        for(int i=1; i<= n; i++){
            if((long)ans*(long)num >= 1000000000L) {
                ans = 1000000000;
                break;
            }
            ans *= num;
        }
        return ans;
    }
    public static int NthRoot(int n, int m) {
        // Write your code here.
        int res = -1;
        int left = 0, right = 1;
        while(right*right <= m)right++;
        right++;
        while(right-left>1){
            int mid = left + (right-left)/2;
            if(multiple(mid, n) <= m){
                left = mid;
            }else{
                right = mid;
            }
        }
        if(multiple(left, n) == m){
            res = left;
        }

        return res;
    }
}
