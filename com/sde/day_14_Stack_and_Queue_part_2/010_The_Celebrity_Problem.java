package com.sde.day_14_Stack_and_Queue_part_2;

import java.util.* ;

/*
	This is signature of helper function 'knows'.
	You should not implement it, or speculate about its implementation.

	boolean knows(int A, int B); 
	Function 'knows(A, B)' will returns "true" if the person having
	id 'A' know the person having id 'B' in the party, "false" otherwise.
	Use it as Runner.knows(A, B);
*/
	
class Solution {
    class Runner{
        static public boolean knows(int a, int b){
            return true;
        }
    }

	public static int findCelebrity(int n) {
        // Write your code here.
		Stack<Integer> stack = new Stack<>();
		for(int i=0; i<n; i++){
			stack.push(i);
		}
		while(stack.size()>=2){
			int a = stack.pop();
			int b = stack.pop();

			if(Runner.knows(a, b)){
				stack.push(b);
			}else{
				stack.push(a);
			}
		}

		int celebrity = stack.pop();

		for(int i=0; i<n; i++){
			if(i!=celebrity){
				if(!Runner.knows(i, celebrity) || Runner.knows(celebrity, i)){
					return -1;
				}
			}
		}
		return celebrity;
    }
}