package com.sde.day_9_recursion;

import java.util.*;

class Solution {
    public void subset(int i, int candidates[], int target, ArrayList<Integer> temp, Set<ArrayList<Integer>> st){
        
        if(i == candidates.length){
            if(target == 0){
                ArrayList<Integer> temp2 = new ArrayList<>(temp);
                st.add(temp2);
            }
            return;
        }
        // take it and be on current
        if(target-candidates[i]>=0){
            temp.add(candidates[i]);
            subset(i+1, candidates, target-candidates[i], temp, st);
            temp.remove(temp.size()-1);
        }
        // leave it
        int next=i+1;
        while(next<candidates.length && candidates[next]==candidates[next-1])next+=1;
        subset(next, candidates, target, temp, st);
    }
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
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