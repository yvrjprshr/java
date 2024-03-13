package com.sde.day_16_string_part_2;

class Solution {
    // using KMP algo
    public int[] constructLPSArray(String A){
        String str = A;
        StringBuilder sb = new StringBuilder(A);
        sb.reverse();
        str = str + "$" + sb.toString();
        int n = str.length();
        int i = 1, prevLPS = 0;
        int lps[] = new int[n];
        while(i < n){
            if(str.charAt(i) == str.charAt(prevLPS)){
                lps[i] = prevLPS+1;
                i++;
                prevLPS++;
            }else{
                if(prevLPS == 0){
                    lps[i] = 0;
                    i++;
                }else{
                    prevLPS = lps[prevLPS-1];
                }
            }
        }
        return lps;
    }
    public int solve(String A) {
        int lps[] = constructLPSArray(A);
        int len = A.length();
        int ans = len - lps[lps.length-1];
        return ans;
    }
}
