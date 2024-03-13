package com.sde.day_11_binary_search;
import java.util.*;   
class Solution {
    public int sumA(ArrayList<Integer> A){
        int sum=0;for(int a:A)sum+=a;return sum;
    }
    public boolean isValid(ArrayList<Integer> A, int target, int B){
        int temp = 0;
        int cnt = 1;
        for(int i=0; i<A.size(); i++){
            if(temp + A.get(i) > target){
                cnt++;
                temp = A.get(i);
            }else{
                temp += A.get(i);
            }
        }
        return cnt <= B;
    }
    public int books(ArrayList<Integer> A, int B) {
        if(A.size() < B) return -1;
        int left = Collections.max(A)-1;
        int right = sumA(A)+1;
        while(right-left>1){
            int mid = left + (right-left)/2;
            if(isValid(A, mid, B)){
                right = mid;
            }else{
                left = mid;
            }
        }
        return right;
    }
}
