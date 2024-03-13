package com.yuvraj.oops;


abstract class A {
    public abstract void swim();
    void run(){
        System.out.println("running....");
    }
}

class B extends A{
    public void swim(){
        System.out.println("swimming....");
    }
}   

public class AbstractDemo {
    public static void main(String[] args) {
        A obj = new B();
        obj.run();
        obj.swim();
    }
}
