package com.yuvraj.practice;

class A{
    class B{
        public void run(){
            System.out.println("running");
        }
    }
    static class C{
        public void hug(){
            System.out.println("hugging");
        }
    }
}
public class InnerClassDemo {
    public static void main(String[] args) {
        A obj = new A();
        A.B obj2 = obj.new B();
        obj2.run();

        A.C obj3 = new A.C();
        obj3.hug();
    }
}
