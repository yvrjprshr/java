package com.sde.day_12_heaps;

import java.util.*;

class Solution {
    class CustomComparator implements Comparator<int[]>{
        public int compare(int a[], int b[]){
            return b[1]-a[1];
        }
    }
    public int[] topKFrequent(int[] nums, int k) {
        HashMap<Integer, Integer> hmap = new HashMap<>();
        for(int i: nums){
            if(hmap.containsKey(i)){
                hmap.put(i, hmap.get(i)+1);
            }else{
                hmap.put(i, 1);
            }
        }
        
        PriorityQueue<int[]> pq = new PriorityQueue<>(new CustomComparator());
        
        hmap.forEach((key, value) -> {
            pq.add(new int[]{key, value});
        });
            
        int ans[] = new int[k];

        int i = 0;

        while(i<k){
            ans[i] = pq.poll()[0];
            i++;
        }
        
        return ans;
    }
}