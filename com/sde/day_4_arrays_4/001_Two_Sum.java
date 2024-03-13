package com.sde.day_4_arrays_4;
import java.util.*;
class Solution {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer>mp= new HashMap<>();
        int arr[] = new int [2];
        for(int i=0; i<nums.length; i++){
            int need = target-nums[i];
            if(mp.containsKey(need)){
                arr[0] = i;
                arr[1] = mp.get(need);
                return arr;
            }
            mp.put(nums[i], i);
        }
        return arr;
    }
}
