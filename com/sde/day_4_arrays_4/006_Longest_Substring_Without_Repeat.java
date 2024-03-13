package com.sde.day_4_arrays_4;
import java.util.*;

class Solution {
    public int lengthOfLongestSubstring(String s) {
        HashMap<Character, Integer> hmap = new HashMap<>();
        int maxi = 0, temp = 0, ptr = 0;
        for(int i=0; i<s.length(); i++){
            char ch = s.charAt(i);
            if(hmap.containsKey(ch) == false){
                temp++;
                maxi = Math.max(maxi, temp);
                hmap.put(ch, 1);
            }else{
                while(ptr <= i && hmap.containsKey(ch)){
                    char ch2 = s.charAt(ptr);
                    hmap.put(ch2, hmap.get(ch2)-1);
                    if(hmap.get(ch2) == 0) hmap.remove(ch2);
                    temp--;
                    ptr++;
                }
                hmap.put(ch, 1);
                temp++;
            }
        }
        return maxi;
        
    }
}