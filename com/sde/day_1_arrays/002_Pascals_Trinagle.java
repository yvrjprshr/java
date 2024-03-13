package com.sde.day_1_arrays;

import java.util.*;

class Solution {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> levels = new ArrayList<>();
        List<Integer> level = new ArrayList<>();
        level.add(1);
        levels.add(level);
        
        for(int i=1; i<numRows; i++){
            level = new ArrayList<>();
            int siz = levels.get(i-1).size();
            level.add(1);
            for(int j=1; j<siz; j++){
                int a = levels.get(i-1).get(j-1);
                int b = levels.get(i-1).get(j);
                level.add(a+b);
            }
            level.add(1);
            levels.add(level);
        }        
        return levels;
    }
}