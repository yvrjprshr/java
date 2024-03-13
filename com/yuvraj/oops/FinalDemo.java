package com.yuvraj.oops;
final class A{ // can not inherit class
    final float PI = 3.14f; // can not change value after initialization
    public final void run(){ // can not override
        System.out.println("running");
    }
}

// class B extends A{
    // public void run(){
        // System.out.println("running");
    // }
// }
public class FinalDemo {
    public static void main(String[] args) {
        
    }
}
