package com.sde.day_13_Stack_and_Queue;

class Solution{
    static class Stack {
        int arr[];
        int ptr;
        Stack(int capacity) {
            // Write your code here.
            ptr=-1;
            arr=new int[capacity];
        }
        public void push(int num) {
            // Write your code here.
            if(ptr+1!=arr.length){
                ptr += 1;
                arr[ptr]=num;
            }
        }

        public int pop() {
            // Write your code here.
            if(ptr == -1) return -1;
            int num = arr[ptr];
            ptr-=1;
            return num;
        }
        public int top() {
            // Write your code here.
            if(ptr==-1){
                return -1;
            }
            return arr[ptr];
        }
        public int isEmpty() {
            // Write your code here.
            if(ptr == -1) return 1;
            return 0;
        }
        public int isFull() {
            // Write your code here.
            if(ptr == arr.length-1) return 1;
            return 0;
        }
    }
}