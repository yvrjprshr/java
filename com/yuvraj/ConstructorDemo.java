package com.yuvraj;
class Calculator{
    int num1;
    int num2;
    int result;
    public Calculator(){
        System.out.println("Default Constructor");
    }
    public Calculator(int a){
        num1 = a;
        num2=3;
        System.out.println("Parameterized Constructor");
    }
    public Calculator(int a, int b){
        num1 = a;
        num2 = b;
        System.out.println("Parameterized Constructor");
    }
   
}

public class ConstructorDemo {
    public static void main(String[] args) {
        Calculator defaultConstructorObj = new Calculator();
        Calculator parameterizedConstructorObj1 = new Calculator(2);
        Calculator parameterizedConstructorObj2 = new Calculator(3, 5);
        System.out.println("defaultConstructorObj"+defaultConstructorObj.num1+", "+defaultConstructorObj.num2);
        System.out.println("parameterizedConstructorObj1"+parameterizedConstructorObj1.num1+", "+parameterizedConstructorObj1.num2);
        System.out.println("parameterizedConstructorObj2"+parameterizedConstructorObj2.num1+", "+parameterizedConstructorObj2.num2);
    }
}
