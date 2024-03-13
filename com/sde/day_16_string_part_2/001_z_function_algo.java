package com.sde.day_16_string_part_2;

class ZFunctionAlgo {
    public static int[] zAlgo(String patt, String text){
        String str = patt + '$' + text;
        
        int o = str.length();
        
        int z[] = new int[o];
        
        int l = 0, r = 0;
        for(int i = 1; i < o; i++){
            if(i <= r){
                z[i] = Math.min(r-i+1, z[i-l]);
            }
            while((i + z[i] < o) && (str.charAt(z[i]) == str.charAt(i+z[i]))){
                z[i]++;
            }
            
            if(i+z[i]-1 > r){
                l = i;
                r = i+z[i]-1;
            }
        }
        
        return z;
    }
    public static void main(String[] args) {
        String patt = "abc";
        String text = "abcooabcmmabcooabcoo";
        int z_res[] = zAlgo(patt, text);
        int cnt = 0;
        for(int i = 0; i < z_res.length; i++){
            if(z_res[i] >= patt.length())cnt++;
        }
        System.out.println(cnt);
    }
}


//////////////////////////////////////////////////////////////////////

class Solution {
    public int[] zAlgo(String patt, String text){
        String str = patt + '$' + text;
        
        int o = str.length();
        
        int z[] = new int[o];
        
        int l = 0, r = 0;
        for(int i = 1; i < o; i++){
            if(i <= r){
                z[i] = Math.min(r-i+1, z[i-l]);
            }
            while((i + z[i] < o) && (str.charAt(z[i]) == str.charAt(i+z[i]))){
                z[i]++;
            }
            
            if(i+z[i]-1 > r){
                l = i;
                r = i+z[i]-1;
            }
        }
        
        return z;
    }
    public int strStr(String haystack, String needle) {
        int z[] = zAlgo(needle, haystack);
        for(int  i = 0; i < z.length; i++){
            if(z[i] >= needle.length()){
                return i-needle.length()-1;
            }
        }
        
        return -1;
    }
}