package com.sde.day_10_recursion_and_backtracking;
import java.util.*;
class Solution {
    public void rec(HashMap<Integer, Boolean> vis, int[] nums, List<Integer> store, List<List<Integer>> ans){
        if(store.size() == nums.length){
            List<Integer> temp = new ArrayList<>(store);
            ans.add(temp);
            return;
        }
        
        for(int i=0; i<nums.length; i++){
            if(!vis.containsKey(nums[i])){
                vis.put(nums[i], true);
                store.add(nums[i]);
                rec(vis, nums, store, ans);
                store.remove(store.size()-1);
                vis.remove(nums[i]);
            }
        }
    }
    public List<List<Integer>> permute(int[] nums) {
        HashMap<Integer, Boolean> vis = new HashMap<>();
        List<Integer> store = new ArrayList<>();
        List<List<Integer>> ans = new ArrayList<>();
        rec(vis, nums, store, ans);
        return ans;
    }
}