package com.yuvraj.abstractinterfacejava;

interface A{
    void run();
    int sum(int a, int b);
    default void printInterfaceName(){
        System.out.println("A");
    }
    default void p(){
        System.out.println("p");
    }
    static void staticMethod(){
        System.out.println("A static method");
    }
}

class Subclass implements A{
    @Override
    public void run(){System.out.println("running");}

    @Override
    public int sum(int a, int b){return a+b;}
}

public class InterfaceDemo {
    public static void main(String[] args) {
        A obj = new Subclass();
        obj.printInterfaceName();
        A.staticMethod();
        System.out.println(obj.sum(3,4));
        obj.run();
        obj.p();
        
    }
}
