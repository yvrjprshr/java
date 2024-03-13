package com.yuvraj.practice;

class School{
    static int numberOfSchools;
    static{
        numberOfSchools=0;
        System.out.println("inside static block");
    }

    public School(){
        System.out.println("inside constructor");
        numberOfSchools++;
    }

    public void run(){
        System.out.println("running");
        System.out.println(numberOfSchools);
    }
}

public class StaticDemo {
    public static void main(String[] args) {
        System.out.println("Number of Schools "+School.numberOfSchools);
        School s1 = new School();s1.run();      
        School s2 = new School();s2.run();
        System.out.println("Number of Schools "+School.numberOfSchools);
    }    
}
