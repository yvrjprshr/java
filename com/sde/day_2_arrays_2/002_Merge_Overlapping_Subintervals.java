package com.sde.day_2_arrays_2;

import java.util.*;
class Solution {
    public int[][] merge(int[][] intervals) {
        int n = intervals.length;
        ArrayList<ArrayList<Integer>> arr = new ArrayList<>();
        Arrays.sort(intervals, (a, b) -> Integer.compare(a[0], b[0]));
        int left = intervals[0][0];
        int right = intervals[0][1];
        
        int i = 0;
        
        while(i < n){
            if(intervals[i][0] <= right){
                right = Math.max(right, intervals[i][1]);
            }else{
                arr.add(new ArrayList<>(Arrays.asList(left, right)));
                left = intervals[i][0];
                right = Math.max(right, intervals[i][1]);
            }
            
            if(i==n-1){
                arr.add(new ArrayList<>(Arrays.asList(left, right)));
                break;
            }
            i++;
        }
        
        int ans[][] = new int[arr.size()][2];
        for(i=0; i<arr.size(); i++){
            ans[i][0] = arr.get(i).get(0);
            ans[i][1] = arr.get(i).get(1);
        }
        return ans;
    }
}