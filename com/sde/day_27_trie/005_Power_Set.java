package com.sde.day_27_trie;

import java.util.*;

class Solution
{
    public List<String> AllPossibleStrings(String s)
    {
        int n = s.length();
        List<String> list = new ArrayList<>();
        
        for(int bit = 0; bit < (1 << n); bit++){
            String str = "";
            for(int i = 0; i < n; i++){
                if((bit & (1<<i)) != 0){
                    str += s.charAt(i);
                }
            }
            if(str.length()>0){
                list.add(str);
            }
        }
        
        Collections.sort(list);
        
        return list;
    }
}
