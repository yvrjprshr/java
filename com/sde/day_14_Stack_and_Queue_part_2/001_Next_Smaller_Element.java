package com.sde.day_14_Stack_and_Queue_part_2;

import java.util.*;
class Solution {
    public ArrayList<Integer> prevSmaller(ArrayList<Integer> A) {
        Stack<Integer> stack = new Stack<>();
        ArrayList<Integer> ans = new ArrayList<>();
        for(int i=0; i<A.size(); i++){
            if(i == 0){
                ans.add(-1);
                stack.push(A.get(0));
            }else{
                while(stack.isEmpty()==false && stack.peek() >= A.get(i)){stack.pop();}
                ans.add(stack.isEmpty() ? -1 : stack.peek());
                stack.push(A.get(i));
            }
        }
        return ans;
    }
}