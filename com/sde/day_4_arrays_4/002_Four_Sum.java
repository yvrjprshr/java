package com.sde.day_4_arrays_4;

import java.util.*;

class Solution {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        int n = nums.length;
        
        HashSet<List<Integer>> set = new HashSet<>();
        
        for(int i=0; i<n; i++){
            for(int j=i+1; j<n; j++){
                Map<Long, Integer> mp = new HashMap<>();
                for(int k=j+1; k<n; k++){
                    long num1 = nums[i];
                    long num2 = nums[j];
                    long num3 = nums[k];
                    long req = (long)target - (num1+num2+num3);
                    if(mp.containsKey(req)){
                        List<Integer> arr = new ArrayList<>();
                        arr.add(nums[i]);
                        arr.add(nums[j]);
                        arr.add(nums[mp.get(req)]);
                        arr.add(nums[k]);
                        Collections.sort(arr);
                        mp.put(nums[k]*1L, k);
                        if(set.contains(arr)==false){
                            set.add(arr);
                        }
                    }else{
                        mp.put(nums[k]*1L, k);
                    }
                }
            }
        }
        List<List<Integer>> ans = new ArrayList<>();
        for(List<Integer> i: set){
            ans.add(i);
        }
        return ans;
    }
}