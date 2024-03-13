package com.yuvraj.MultiThreading;


class Hi implements Runnable{
    public void run(){
        for(int i = 1; i <= 5; i++){
            System.out.println(i);
            try{
                Thread.sleep(100);
            }catch(Exception e){}
        }
    }
}
class Hello implements Runnable{
    public void run(){
        for(int i = 1; i <= 5; i++){
            System.out.println(i);
            try{
                Thread.sleep(100);
            }catch(Exception e){}
        }
    }
}

public class UsingRunnableInterface {
    public static void main(String[] args) {
        // Thread -> Unit of a Process
        Hi hi = new Hi();
        Hello hello = new Hello();
        
        Thread t1 = new Thread(hi);
        Thread t2 = new Thread(hello);

        t1.start();
        t2.start();

        System.out.println(t1.isAlive()); // true
        try{
            t1.join();
            t2.join();
        }catch(Exception e){}
        System.out.println(t1.isAlive()); // false

        System.out.println("End of program");
    }
}
