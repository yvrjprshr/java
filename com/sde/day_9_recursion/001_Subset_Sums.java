package com.sde.day_9_recursion;
import java.util.*;
class Solution{
    public void subset(int i, int sum, ArrayList<Integer> arr, int N, ArrayList<Integer> ans){
        if(i == N){
            ans.add(sum);
            return;
        }
        subset(i+1, sum, arr, N, ans);
        subset(i+1, sum+arr.get(i), arr, N, ans);
    }
    ArrayList<Integer> subsetSums(ArrayList<Integer> arr, int N){
        // code here
        ArrayList<Integer> ans = new ArrayList<>();
        subset(0, 0, arr, N, ans);
        return ans;
    }
}