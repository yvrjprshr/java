package com.yuvraj.oops;

class A{
    public A(){
        System.out.println("Parent Class Default Constructor");
    }
    public A(int i){
        System.out.println("Parent class Parameterized Constructor");
    }
}

class B extends A{
    public B(){
        super(2);
        System.out.println("Child Class Default Constructor");
    }
    public B(int i){
        super(23);
        System.out.println("Child class Parameterized Constructor");
    }
}

public class SuperMethodDemo {
    public static void main(String[] args) {
        System.out.println("hey");
        A obj = new A(3);
        System.out.println("hey");
    }
}
