package com.sde.day_15_string;
import java.util.*;
class Solution {
    public String longestCommonPrefix(String[] strs) {
        if(strs.length==1)return strs[0];
        Arrays.sort(strs);
        int i=0,j=0;
        while(i<strs[0].length() && j<strs[strs.length-1].length() && (strs[0].charAt(i)==strs[strs.length-1].charAt(j))){
            i++;
            j++;
        }
        return strs[0].substring(0,i);
    }
}