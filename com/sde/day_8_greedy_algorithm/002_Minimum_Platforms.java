package com.sde.day_8_greedy_algorithm;
import java.util.*;
class Solution{
    static int findPlatform(int arr[], int dep[], int n)
    {
        Arrays.sort(arr);
        Arrays.sort(dep);
        
        int platforms = 1, result = 1;
        int i = 1, j = 0;
        while(i < n && j < n){
            if(arr[i] <= dep[j]){
                platforms++;
                i++;
            }else{
                platforms--;
                j++;
            }
            result = Math.max(result, platforms);
        }
        return result;
    }
}