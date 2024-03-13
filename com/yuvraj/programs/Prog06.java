package com.yuvraj.programs;


class Student{
    public String fname;
    public int roll;
    public String lname;

    public Student(String fname, String lname, int roll){
        this.fname = fname;
        this.lname = lname;
        this.roll = roll;
    }

    public String getFname(){
        return this.fname;
    }

    public String getLname(){
        return this.lname;
    }

    public int roll(){
        return this.roll;
    }
}

public class Prog06 {
    public static void main(String[] args) {
        Student st = new Student("yuvraj", "parashar", 90);
    }
}
