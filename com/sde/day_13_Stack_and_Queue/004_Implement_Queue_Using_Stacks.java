package com.sde.day_13_Stack_and_Queue;
import java.util.*;
class MyQueue {
    Stack<Integer> ip, op;
    public MyQueue() {
        ip = new Stack<>();
        op = new Stack<>();
    }
    
    public void push(int x) {
        ip.add(x);
    }
    
    public int pop() {
        if(op.isEmpty()){
            while(ip.isEmpty()==false){
                op.push(ip.pop());
            }
        }
        int x = op.pop();
        return x;
    }
    
    public int peek() {
        if(op.isEmpty()){
            while(ip.isEmpty()==false){
                op.push(ip.pop());
            }
        }
        int x = op.peek();
        return x;
    }
    
    public boolean empty() {
        if(ip.size() + op.size() == 0){
            return true;
        }
        return false;
    }
}

/**
 * Your MyQueue object will be instantiated and called as such:
 * MyQueue obj = new MyQueue();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.peek();
 * boolean param_4 = obj.empty();
 */