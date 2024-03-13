package com.sde.day_26_dp;

import java.util.*;

class Solution{
    static boolean isPal(String str){
        int n = str.length();
        int i = 0, j = n-1;
        while(i<j){
            if(str.charAt(i) != str.charAt(j)){
                return false;
            }
            i++;
            j--;
        }
        return true;
    }
    
    static int memo(String str, HashMap<String, Integer> dp){
        if(str.compareTo("")==0) return 0;
        if(dp.containsKey(str)) return dp.get(str);
        int ans = Integer.MAX_VALUE;
        for(int i = 0; i < str.length(); i++){
            String curr = str.substring(0,i+1);
            if(isPal(curr)){
                String rem = str.substring(i+1);
                int temp = 1 + memo(rem, dp);
                ans = Math.min(ans, temp);
            }
        }
        dp.put(str, ans);
        return ans;
    }
    
    static int palindromicPartition(String str){
        HashMap<String, Integer> dp = new HashMap<>();
        return memo(str,dp)-1;
    }
}