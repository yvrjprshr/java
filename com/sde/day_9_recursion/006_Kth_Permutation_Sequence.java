package com.sde.day_9_recursion;
import java.util.*;
class Solution {
    public String getPermutation(int n, int k) {
        StringBuilder ans = new StringBuilder();
        int fact = 1;
        List<Integer> numbers = new ArrayList<>();
        for(int i=1; i<n; i++){
            fact = fact * i;
            numbers.add(i);
        }
        numbers.add(n);
        k = k-1;
        while(true){
            ans.append(numbers.get(k/fact));
            numbers.remove(k/fact);
            if(numbers.size()==0)break;
            k = k%fact;
            fact = fact/numbers.size();
        }
        return ans.toString();
    }
}
