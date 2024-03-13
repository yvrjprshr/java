package com.sde.day_15_string;
import java.util.*;
class Solution {
    public int romanToInt(String s) {
        HashMap<Character, Integer> hmap = new HashMap<>();
        
        hmap.put('I', 1);
        hmap.put('V', 5);
        hmap.put('X', 10);
        hmap.put('L', 50);
        hmap.put('C', 100);
        hmap.put('D', 500);
        hmap.put('M', 1000);
        
        int n = s.length();
        int res = 0;
        for(int i = 0; i < n; i++){
            if(i+1<n && hmap.get(s.charAt(i)) < hmap.get(s.charAt(i+1))){
                res -= hmap.get(s.charAt(i));
            }else{
                res += hmap.get(s.charAt(i));
            }
        }
        
        return res;
    }
}