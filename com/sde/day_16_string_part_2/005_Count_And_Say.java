package com.sde.day_16_string_part_2;
class Solution {
    public String countAndSay(int n) {
        if(n == 1) return "1";
        if(n == 2) return "11";
        
        String str = "11";
        
        for(int i = 3; i <= n; i++){
            int cnt = 1;
            String temp = "";
            str += "$";
            for(int j = 1; j < str.length(); j++){
                if(str.charAt(j-1) == str.charAt(j)){
                   cnt++; 
                }else{
                    temp += Integer.toString(cnt);
                    temp += str.charAt(j-1);
                    cnt = 1;
                }
            }
            str = temp;
        }
        
        return str;
    }
}