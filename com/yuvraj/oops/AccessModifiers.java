package com.yuvraj.oops;

class A{
    int a = 10;
}
class B extends A{
    public void prin(){
        System.out.println(a);
    }
}

public class AccessModifiers {
    public static void main(String[] args) {
        /**
         * Final
         * Abstract
         * Private
         * Public
         * Protected
         * 
         * If there is no access specifiers, [default] access modifier will be there
         * 
         * for a class only [public, abstract, and final are permitted]
        */
        B obj = new B();
        obj.prin();
    }
}
