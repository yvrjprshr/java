package com.yuvraj.oops;
interface Writer{
    int sum(int a, int b);
}

class WriterClass implements Writer{
    public int sum(int a, int b){
        return a+b;
    }
}

public class InterfaceDemo {
    public static void main(String[] args) {
        WriterClass obj = new WriterClass();
        int x = obj.sum(2, 3);    
        System.out.println(x);
    }
    
}
