package com.sde.day_16_string_part_2;

class Solution {
    public int strStr(String haystack, String needle) {
        int m = haystack.length();
        int n = needle.length();
        if (n == 0) return 0;
        if (n > m) return -1;
        
        // KMP O(m+n) time complexity
        
        // first build longest prefix suffix array 
        int[] lps = new int[n];
        int prevLPS = 0;
        int i = 1;
        while (i < n) { // Time complexity: average O(n) worst case O(2*n)
            if (needle.charAt(prevLPS) == needle.charAt(i)) {
                lps[i] = prevLPS + 1;
                i++; prevLPS++;
            }
            else if (prevLPS == 0) {
                lps[i] = 0;
                i++;
            }
            else {
                prevLPS = lps[prevLPS-1];
            }
        }
        
        // now search for needle in haystack using lps array
        i = 0;
        int j = 0;
        while (i < m) { 
            // if both chars are equal increment both i and j
            if (haystack.charAt(i) == needle.charAt(j)) {
                i++; j++;
            }
            else {
                // no prefix suffix matches current char in haystack
                // start search from beginning of needle and increment haystack pointer
                if (j == 0)
                    i++;
                else 
                    j = lps[j-1];
            }
            // check if needle pointer is at end of needle, if so return index i - length of needle
            if (j == n)
                return i - n;
        }
        return -1;
    }
}