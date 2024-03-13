package com.yuvraj.oops;


class A{
    public void run(){
        System.out.println("running in A");
    }
}

class B extends A{
    public void run(){
        System.out.println("running in B");
    }
}
public class MethodOverriding {
    public static void main(String[] args) {
        B obj = new B();
        obj.run();
    }
}
