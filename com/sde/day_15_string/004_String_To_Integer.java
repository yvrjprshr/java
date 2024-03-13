package com.sde.day_15_string;

class Solution {
    public int myAtoi(String s) {
        int n = s.length();
        int i = 0;
        int res = 0;
        
        // removing leading spaces
        while(i<n && s.charAt(i) == ' ')i++;
        
        if(i == n) return res;
        boolean neg = s.charAt(i) == '-';
        if(neg || s.charAt(i)=='+')i++;
        
        while(i<n && s.charAt(i)>='0'&&s.charAt(i)<='9'){
            int num = s.charAt(i)-'0';
            if((res > Integer.MAX_VALUE/10) ||( res == Integer.MAX_VALUE/10 && num > Integer.MAX_VALUE%10)){
                if(neg){
                    return Integer.MIN_VALUE;
                }else{
                    return Integer.MAX_VALUE;
                }
            }
            
            res = (res*10)+num;
            i++;
        }
        
        return neg ? -1*res : res ;
    }
}