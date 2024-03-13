package com.sde.day_14_Stack_and_Queue_part_2;

import java.util.*;

class StockSpanner {
    Stack<int[]> stack;
    public StockSpanner() {
        stack = new Stack<>();
    }
    
    public int next(int price) {
        int cnt = 1;
        while(!stack.isEmpty() && stack.peek()[0] <= price){
            cnt += stack.peek()[1];
            stack.pop();
        }
        stack.push(new int[]{price, cnt});
        return cnt;
    }
}