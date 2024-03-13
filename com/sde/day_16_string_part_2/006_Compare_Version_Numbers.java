package com.sde.day_16_string_part_2;

import java.util.*;

class Solution {
    public int compareVersion(String version1, String version2) {
        List<Integer> list1 = new ArrayList<>();
        List<Integer> list2 = new ArrayList<>();
        
        String temp = "";
        version1 += ".";
        for(int i = 0; i < version1.length(); i++){
            if(version1.charAt(i) == '.'){
                list1.add(Integer.valueOf(temp));
                temp = "";
            }else{
                temp += version1.charAt(i);
            }
        }
        
        
        temp = "";
        version2 += ".";
        for(int i = 0; i < version2.length(); i++){
            if(version2.charAt(i) == '.'){
                list2.add(Integer.valueOf(temp));
                temp = "";
            }else{
                temp += version2.charAt(i);
            }
        }
        
        System.out.println(list1);
        System.out.println(list2);
        
        int i;
        for(i=0; i < Math.min(list1.size(), list2.size()); i++){
            if(list1.get(i) > list2.get(i)){
                return 1;
            }else if(list1.get(i) < list2.get(i)){
                return -1;
            }
        }
        while(i < list1.size()){
            if(list1.get(i) != 0) return 1;i++;
        }
        while(i < list2.size()){
            if(list2.get(i) != 0) return -1;i++;
        }
        return 0;
    }
}