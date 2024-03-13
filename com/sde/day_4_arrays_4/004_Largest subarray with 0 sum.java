package com.sde.day_4_arrays_4;
import java.util.*;
class GfG
{
    int maxLen(int arr[], int n)
    {
        int prefix_sum[] = new int[n];
        
        HashMap<Integer, Integer> hmap = new HashMap<>();
        
        int ans = 0;
        
        for(int i=0; i<n; i++){
            prefix_sum[i] = arr[i];
            if(i>0){
                prefix_sum[i] += prefix_sum[i-1];
            }
            if(prefix_sum[i] == 0){
                ans = Math.max(ans, i+1);
            }
            if(!hmap.containsKey(prefix_sum[i])){
                hmap.put(prefix_sum[i], i);
            }else{
                ans = Math.max(ans, i-hmap.get(prefix_sum[i]));
            }
        }
        return ans;
    }
}