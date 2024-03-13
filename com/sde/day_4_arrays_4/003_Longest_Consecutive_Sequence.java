package com.sde.day_4_arrays_4;

import java.util.*;

class Solution {
    public int longestConsecutive(int[] nums) {
        int ans = 0;
        Set<Integer> st = new HashSet<>();
        for(int i: nums)st.add(i);
        for(int i: st){
            if(st.contains(i-1)==false){
                int cnt = 0;
                int num = i;
                while(st.contains(num)){
                    cnt++;
                    num++;
                }
                ans = Math.max(ans, cnt);
            }
        }
        return ans;
    }
}