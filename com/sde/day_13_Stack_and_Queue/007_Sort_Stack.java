package com.sde.day_13_Stack_and_Queue;
import java.util.* ;
class Solution {
	public static void sortedInsert(Stack<Integer> stack, int x){
		if(stack.isEmpty() || stack.peek() < x){
			stack.push(x);
			return;
		}
		int popp = stack.pop();
		sortedInsert(stack, x);
		stack.push(popp);
	}
    
	public static void sortStack(Stack<Integer> stack){
		if(stack.isEmpty()){
			return;
		}
		int popp = stack.pop();
		sortStack(stack);
		sortedInsert(stack , popp);
	}
}