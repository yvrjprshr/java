package com.yuvraj;
class Casio{
    // constructor overloading
    public Casio(){
        System.out.println("def");
    }
    public Casio(int x){
        System.out.println("param");
    }


    // method overloading
    public int add (int a, int b){
        return a+b;
    }
    public int add (int a, int b, int c){
        return a+b+c;
    }
    public double add(double a, double b){
        return a+b;
    }
}

public class MethodOverloading {
    public static void main(String[] args) {
        Casio obj1 = new Casio();
        Casio obj2 = new Casio(2);
        System.out.println(obj1.add(2, 9));
        System.out.println(obj1.add(1, 2, 3));
        System.out.println(obj2.add(2.3, 2.4));
    }
}
