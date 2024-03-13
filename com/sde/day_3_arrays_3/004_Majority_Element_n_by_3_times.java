package com.sde.day_3_arrays_3;
import java.util.*;

/**
 * int x = n/3;
 * int y = n/(x+1)
 * so there will be at max 2 elements as answer
*/

class Solution {
    public List<Integer> majorityElement(int[] nums) {
        
        // Extended Boyer Moore’s Voting Algorithm
        int element1 = Integer.MAX_VALUE;
        int element2 = Integer.MAX_VALUE;
        
        int cnt1 = 0;
        int cnt2 = 0;
        
        for(int i=0; i<nums.length; i++){
            if(cnt1 == 0 && nums[i] != element2){
                element1 = nums[i];
                cnt1 = 1;
            }else if(cnt2 == 0 && nums[i] != element1){
                element2 = nums[i];
                cnt2 = 1;
            }else if(nums[i] == element1){
                cnt1++;
            }else if(nums[i] == element2){
                cnt2++;
            }else{
                cnt1--;
                cnt2--;
            }
        }
        
        // Manual check
        int req = (nums.length/3) + 1;
        cnt1=0;cnt2=0;
        boolean num1 = false, num2 = false;
        for(int i=0;i<nums.length;i++){
            if(nums[i]==element1)cnt1++;
            else if(nums[i]==element2)cnt2++;
        }
        if(cnt1>=req)num1=true;
        if(cnt2>=req)num2=true;
        
        List<Integer> ans = new ArrayList<>();
        if(num1) ans.add(element1);
        if(num2) ans.add(element2);
        return ans;
    }
}