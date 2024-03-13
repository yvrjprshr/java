package com.sde.day_3_arrays_3;

class Solution {
    public double binPow(double x, long n) {
        if(n == 0){
            double ans = 1;
            return ans;
        }
        
        double ans = binPow(x, n/2);
        ans *= ans;
        
        if(n%2 == 1){
            ans *= x;
        }
        
        return ans;
    }
    
    public double myPow(double x, int n) {
        long num = (long)n;
        double ans = binPow(x, Math.abs(num));
        if(num < 0){
            ans = (double)1/ans;
        }
        return ans;
    }
}