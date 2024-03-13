package com.sde.day_10_recursion_and_backtracking;

import java.util.*;

class Solution {
    public boolean res(String s, HashMap<String, Boolean> hmap, HashMap<String, Boolean> dp){
        if(s=="")return true;
        if(dp.containsKey(s)){
            return dp.get(s);
        }
        int n = s.length();
        for(int i=0; i < n; i++){
            String temp = s.substring(0, i+1);
            if(hmap.containsKey(temp)){
                String rem = i+1 == n ? "" : s.substring(i+1, s.length());
                if(res(rem, hmap, dp)){
                    dp.put(s, true);
                    return true;
                }
            }
        }
        dp.put(s, false);
        return false;
    }
    public boolean wordBreak(String s, List<String> wordDict) {
        HashMap<String, Boolean> hmap = new HashMap<>();
        HashMap<String, Boolean> dp = new HashMap<>();
        for(String t : wordDict){
            hmap.put(t, true);
        }       
        return res(s, hmap, dp);
    }
}