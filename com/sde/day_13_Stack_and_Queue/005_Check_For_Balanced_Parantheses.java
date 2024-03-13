package com.sde.day_13_Stack_and_Queue;
import java.util.*;
class Solution {
    public boolean isValid(String s) {
        Stack<Character> st = new Stack<>();
        for(int i = 0; i < s.length(); i++){
            char ch = s.charAt(i);
            if(ch == '(' || ch == '[' || ch == '{'){
                st.push(ch);
            }else{
                if(st.isEmpty()){
                    return false;
                }
                char ch2 = st.peek();
                if((ch == ')' && ch2 == '(') || (ch == '}' && ch2 == '{') || (ch == ']' && ch2 == '[')){
                    st.pop();
                }else{
                    return false;
                }
            }
        }
        
        if(st.isEmpty()){
            return true;
        }
        
        return false;
    }
}