package com.yuvraj.oops;


class Calculator{
    public int add (int i, int j){
        return i+j;
    }
}

class CalculatorAdvance extends Calculator{ // single Inheritance
    public int sub(int i, int j){
        return i-j;
    }
}

class CalculatorVeryAdvance extends CalculatorAdvance{ // Multilevel Inheritance
    public int mul(int i, int j){
        return i*j;
    }
}

// The type of inheritance where many subclasses inherit from one single class is known as Hierarchical Inheritance. 
class A{
}
class B extends A{
}
class C extends A{
}

// Multiple inheritances is a type of inheritance where a subclass can inherit features from more than one parent class. Multiple inheritances should not be confused with multi-level inheritance, in multiple inheritances the newly derived class can have more than one superclass. And this newly derived class can inherit the features from these superclasses it has inherited from, so there are no restrictions.  In java, multiple inheritances can be achieved through interfaces.

// Hybrid inheritance is a combination of more than two types of inheritances single and multiple. 
    
public class InheritanceDemo {
    public static void main(String[] args) {
        CalculatorAdvance obj = new CalculatorAdvance();
        System.out.println(obj.add(2, 90));
        System.out.println(obj.sub(23 , 3));


        CalculatorVeryAdvance objVeryAdvance = new CalculatorVeryAdvance();
        System.out.println(objVeryAdvance.add(2, 4));
        System.out.println(objVeryAdvance.sub(2, 4));
        System.out.println(objVeryAdvance.mul(2, 4));
    }
}
