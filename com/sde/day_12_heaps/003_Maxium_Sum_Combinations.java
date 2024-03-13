package com.sde.day_12_heaps;

import java.util.*;
class Solution {
    public class CustomComparator implements Comparator<int[]>{
        public int compare(int[]a, int[]b){
            return b[0]-a[0];
        }
    }
    public ArrayList<Integer> solve(ArrayList<Integer> A, ArrayList<Integer> B, int C) {
        Collections.sort(A, Collections.reverseOrder());
        Collections.sort(B, Collections.reverseOrder());
        ArrayList<Integer> ans = new ArrayList<>();
        Set<String> st = new HashSet<>();
        PriorityQueue<int[]> pq = new PriorityQueue<>(new CustomComparator());
        pq.add(new int[]{A.get(0)+B.get(0), 0, 0});
        st.add(0+"-"+0);
        while(true){
            int [] temp = pq.poll();
            ans.add(temp[0]);
            if(ans.size() == C) break;
            
            int i = temp[1];
            int j = temp[2];
            
            String str1 = (i)+"-"+(j+1);
            String str2 = (i+1)+"-"+(j);
            
            if(j+1 < B.size() && st.contains(str1)==false){
                pq.add(new int[]{A.get(i)+B.get(j+1), i, j+1});
                st.add(str1);
            }
            
            if(i+1 < A.size() && st.contains(str2)==false){
                pq.add(new int[]{A.get(i+1)+B.get(j), i+1, j});
                st.add(str2);
            }
        }
        return ans;        
    }
}