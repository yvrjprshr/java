package com.sde.day_15_string;

class Solution {
    public String longestPalindrome(String s) {
        // consider it as a middle of palindrome and check how far it can go with this middle
        
        int maxLen = 0;
        String maxPal = "";
        
        for(int i = 0; i < s.length(); i++){
            int left = i;
            int right = i;
            
            while(left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)){
                if(right-left+1 > maxLen){
                    maxLen = right-left+1;
                    maxPal = s.substring(left,right+1);
                }
                left -= 1;
                right += 1;
            }
            
            left = i;
            right = i+1;
            
            while(left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)){
                if(right-left+1 > maxLen){
                    maxLen = right-left+1;
                    maxPal = s.substring(left,right+1);
                }
                left -= 1;
                right += 1;
            }
        }
        
        return maxPal;
    }
}