package com.sde.day_13_Stack_and_Queue;
import java.util.*;
class Solution {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        HashMap<Integer, Integer> hmap = new HashMap<>();
        int m = nums1.length;
        int n = nums2.length;
        Stack<Integer> st = new Stack<>();
        for(int i=n-1; i>=0; i--){
            if(i == n-1){
                hmap.put(nums2[i], -1);
                st.add(nums2[i]);
            }else{
                while(st.isEmpty()==false && st.peek() <= nums2[i]){
                    st.pop();
                }
                if(st.isEmpty()){
                    hmap.put(nums2[i], -1);
                }else{
                    hmap.put(nums2[i], st.peek());
                }
                st.add(nums2[i]);
            }
        }
        int ans [] = new int[m];
        for(int i=0; i<m; i++){
            ans[i] = hmap.get(nums1[i]);
        }
        return ans;
    }
}