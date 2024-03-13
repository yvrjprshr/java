package com.sde.day_4_arrays_4;
 import java.util.*;
 
class Solution {
    public int solve(ArrayList<Integer> A, int B) {
        int xor = 0, cnt = 0;
        HashMap<Integer, Integer> hmap = new HashMap<>();
        hmap.put(xor, 1);
        for(int i = 0; i < A.size(); i++){
            xor = xor ^ A.get(i);
            int req = xor ^ B;
            if(hmap.containsKey(req)){
                cnt += hmap.get(req);
            }
            if(hmap.containsKey(xor)){
                hmap.put(xor, hmap.get(xor)+1);
            }else{
                hmap.put(xor, 1);
            }
        }
        return cnt;
    }
}
