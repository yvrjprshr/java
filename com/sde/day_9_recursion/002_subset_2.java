package com.sde.day_9_recursion;
import java.util.*;
class Solution {
    public void subset(int i, int[] nums, ArrayList<Integer> temp, Set<ArrayList<Integer>> st){
        if(i == nums.length){
            ArrayList<Integer> t = new ArrayList<>(temp);
            st.add(t);
            return;
        }
        temp.add(nums[i]);
        subset(i+1, nums, temp, st);
        temp.remove(temp.size()-1);
        subset(i+1, nums, temp, st);
    }
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        Set<ArrayList<Integer>> st = new HashSet<>();
        ArrayList<Integer> temp = new ArrayList<>();
        subset(0, nums, temp, st);
        List<List<Integer>> ans = new ArrayList<>();
        for(ArrayList<Integer> tt: st){
            ans.add(tt);
        }
        return ans;
    }
}