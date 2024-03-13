package com.yuvraj;
public class SelectionDemo {
    public static void main(String[] args) {
        System.out.println("if else switch");
        // Ternary Op
        int age = 19;
        boolean isAdult = age >= 18 ? true : false;
        System.out.println(isAdult);

        // switch
        int num = 3;
        switch (num) {
            case 1:
                System.out.println("one");
                break;
            case 2:
                System.out.println("two");
                break;
            case 3:
                System.out.println("three");
                break;
            default:
                System.out.println("default");
                break;
        }
    }
}
