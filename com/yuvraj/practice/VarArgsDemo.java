package com.yuvraj.practice;

class SumProvider{
    public int sum(int ... arr){
        int sum = 0;
        for(int x : arr){
            sum += x;
        }
        return sum;
    }
}

public class VarArgsDemo {
    public static void main(String[] args) {
        SumProvider obj = new SumProvider();
        int res = obj.sum(1, 2, 3, 4, 5, 6);
        System.out.println(res);
    }    
}
