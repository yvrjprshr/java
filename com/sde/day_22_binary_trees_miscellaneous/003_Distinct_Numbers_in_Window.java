package com.sde.day_22_binary_trees_miscellaneous;

import java.util.*;

class Solution {
    public int[] dNums(int[] A, int B) {
        int n = A.length;
        if(n < B) return new int[0];
        int siz = n-B+1;
        int ans[] = new int[siz];
        HashMap<Integer, Integer> hmap = new HashMap<>();
        int cnt = 0;
        for(int i=0;i<B;i++){
            if(hmap.containsKey(A[i])){
                hmap.put(A[i], hmap.get(A[i])+1);
            }else{
                cnt++;
                hmap.put(A[i], 1);
            }
        }
        int x = 0;
        ans[x] = cnt;
         
        int ptr1 = 0;
        int ptr2 = B;
        
        while(ptr2 < n){
            if(hmap.containsKey(A[ptr2])){
                hmap.put(A[ptr2], hmap.get(A[ptr2])+1);
            }else{
                cnt++;
                hmap.put(A[ptr2], 1);
            }
            
            if(hmap.get(A[ptr1]) == 1){
                cnt--;
                hmap.remove(A[ptr1]);
            }else{
                hmap.put(A[ptr1], hmap.get(A[ptr1])-1);
            }
            x++;
            ans[x] = cnt;
            ptr1++;
            ptr2++;
        }
        
        return ans;
    }
}
