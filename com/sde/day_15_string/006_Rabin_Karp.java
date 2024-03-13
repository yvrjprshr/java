package com.sde.day_15_string;

class Solution {
    public boolean rabinKarp(String patt, String text){
        long prime = 31;
        long mod = Integer.MAX_VALUE;
        
        int p_len = patt.length();
        int t_len = text.length();
        
        long power[] = new long[Math.max(p_len, t_len)];
        power[0]=1;
        for(int i=1; i<power.length; i++){
            power[i] = (power[i-1]*prime)%mod;
        }
        
        long hashText[] = new long[t_len+1];
        hashText[0] = 0;
        for(int i=0; i<t_len; i++){
            hashText[i+1] = (hashText[i] + (text.charAt(i)-'a'+1) * power[i]) % mod;
        }
        
        long hashPatt = 0;
        for(int i = 0; i < p_len; i++){
            hashPatt = (hashPatt + (patt.charAt(i)-'a'+1) * power[i]) % mod;
        }
        
        for(int i=0; i+p_len-1 < t_len; i++){
            long currHash = (hashText[i+p_len] - hashText[i] + mod) % mod;
            if(currHash == (hashPatt * power[i] % mod)){
                return true;
            }
        }
        return false;
    }
    public int repeatedStringMatch(String a, String b) {
        if(a == b) return 1;
        
        int cnt = 1;
        String text = a;
        while(text.length()<b.length()){
            text += a;
            cnt++;
        }
        
        if(text == b){
            return cnt;
        }
        
        if(rabinKarp(b, text)) return cnt;
        text += a;
        if(rabinKarp(b, text)) return cnt+1;
        
        return -1;
    }
}