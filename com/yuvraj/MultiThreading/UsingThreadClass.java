package com.yuvraj.MultiThreading;


class Hi extends Thread{
    public void run(){
        for(int i = 1; i <= 5; i++){
            System.out.println(i);
            try{
                Thread.sleep(100);
            }catch(Exception e){}
        }
    }
}
class Hello extends Thread{
    public void run(){
        for(int i = 1; i <= 5; i++){
            System.out.println(i);
            try{
                Thread.sleep(100);
            }catch(Exception e){}
        }
    }
}

public class UsingThreadClass {
    public static void main(String[] args) {
        // Thread -> Unit of a Process
        Hi hi = new Hi();
        Hello hello = new Hello();
        // hi.run();
        // hello.run();
        hi.start();
        try{Thread.sleep(101);}catch(Exception e){}
        hello.start();
    }
}
