package com.sde.day_14_Stack_and_Queue_part_2;
import java.util.*;
class MinStack {
    Stack<int[]> stack;
    public MinStack() {
        stack = new Stack<>();
    }
    
    public void push(int val) {
        int min;
        if(stack.isEmpty()){
            min = val;
        }else{
            min = Math.min(stack.peek()[1], val);
        }
        stack.push(new int[]{val, min});
    }
    
    public void pop() {
        stack.pop();
    }
    
    public int top() {
        return stack.peek()[0];
    }
    
    public int getMin() {
        return stack.peek()[1];
    }
}

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(val);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */