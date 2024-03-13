package com.yuvraj.MultiThreading;

class A extends Thread{
    public void run (){
        System.out.println("running....");
    }
}

class B implements Runnable{
    public void run(){
        System.out.println("inside Runnable Thread Interface");
    }
}
public class PracticeThread {
    
    public static void main(String[] args) {
        A obj = new A();
        obj.start();

        B o = new B();
        Thread t = new Thread(o);
        t.start();
    }
}
