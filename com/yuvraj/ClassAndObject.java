package com.yuvraj;
class Calculator{
    int num1;
    int num2;
    int result;
    public void add(){
        result = num1+num2;
    }
}

public class ClassAndObject {
    public static void main(String[] args) {
        Calculator obj; // reference to class
        obj = new Calculator(); // assigning object to reference
        obj.num1 = 3;
        obj.num2 = 4;
        System.out.println(obj.result);
        obj.add();
        System.out.println(obj.result);
    }
}
