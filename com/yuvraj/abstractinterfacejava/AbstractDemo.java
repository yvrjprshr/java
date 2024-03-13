package com.yuvraj.abstractinterfacejava;

abstract class A{
    public abstract int abstractMethod();
    void concreteMethod(){System.out.println("concrete method");}
}
class B extends A{
    @Override
    public int abstractMethod(){
        System.out.println("concrete/regular method");
        return 0;
    }
}
public class AbstractDemo {
    public static void main(String[] args) {
        A obj = new B();
        obj.abstractMethod();
        obj.concreteMethod();
    }
}
