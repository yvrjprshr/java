package com.sde.day_9_recursion;

import java.util.*;

class Solution {
    public void subset(int i, int candidates[], int target, ArrayList<Integer> temp, Set<ArrayList<Integer>> st){
        if(target == 0){
            ArrayList<Integer> temp2 = new ArrayList<>(temp);
            st.add(temp2);
            return;
        }
        if(i == candidates.length){
            return;
        }
        // take it and be on current
        if(target-candidates[i]>=0){
            temp.add(candidates[i]);
            subset(i, candidates, target-candidates[i], temp, st);
            temp.remove(temp.size()-1);
        }
        // leave it
        subset(i+1, candidates, target, temp, st);
    }
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        Set<ArrayList<Integer>> st = new HashSet<>();
        ArrayList<Integer> temp = new ArrayList<>();
        subset(0, candidates, target, temp, st);
        List<List<Integer>> lst = new ArrayList<>();
        for(ArrayList<Integer> arr: st){
            lst.add(arr);
        }
        return lst;
    }
}