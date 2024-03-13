package com.sde.day_26_dp;
import java.util.*;
class Solution {
    public boolean memo(String s, HashMap<String, Boolean> hmap, HashMap<String, Boolean> dp){
        if(s == "") return true;
        if(dp.containsKey(s)) return dp.get(s);
        for(int i = 0; i < s.length(); i++){
            String str = s.substring(0,i+1);
            if(hmap.containsKey(str)){
                String temp = s.substring(i+1);
                if(memo(temp, hmap, dp)) {
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
        for(String str: wordDict){
            hmap.put(str, true);
        }
        return memo(s, hmap, dp);
    }
}