package com.yuvraj.oops;

interface A{
    void run();
}
interface B{
    void sleep();
}
class Cl implements A, B{
    public void run(){System.out.println("running");}
    public void sleep(){System.out.println("sleeping");}
}

public class MultipleInheritanceInterfaces {
    public static void main(String[] args) {
        Cl obj = new Cl();
        obj.run();
        obj.sleep();
    }
}
