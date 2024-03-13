package com.sde.day_9_recursion;
import java.util.*;
class Solution {
    public boolean isPalindrome(String s){
        int n = s.length();
        int i = 0;
        int j = n-1;
        while(i <= j){
            if(s.charAt(i)!=s.charAt(j)){
                return false;
            }
            i++;j--;
        }
        return true;
    } 
    public void part(int ind, String s, List<String> store, List<List<String>> ans){
        if(ind == s.length()){
            ArrayList<String> temp = new ArrayList<>(store);
            ans.add(temp);
            return;
        }
        
        for(int i = ind; i < s.length(); i++){
            if(isPalindrome(s.substring(ind, i+1))){
                store.add(s.substring(ind, i+1));
                part(i+1, s, store, ans);
                store.remove(store.size()-1);
            }
        }
    }
    
    public List<List<String>> partition(String s) {
        ArrayList<String> store = new ArrayList<>();
        List<List<String>> ans = new ArrayList<>();
        part(0, s, store, ans);
        return ans;
    }
}