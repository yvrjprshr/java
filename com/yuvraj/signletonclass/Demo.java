package com.yuvraj.signletonclass;

class SingletonClass {

    // Step 1: Private static variable to hold the single instance
    private static SingletonClass instance;

    // Step 2: Private constructor to prevent instantiation from outside the class
    private SingletonClass() {
        // Constructor implementation (if needed)
    }

    // Step 3: Public static method to provide access to the single instance
    public static SingletonClass getInstance() {
        // Lazy initialization - create the instance only when requested for the first
        // time
        if (instance == null) {
            instance = new SingletonClass();
        }
        return instance;
    }

    // Other methods and attributes can be defined here...
}

public class Demo {
    public static void main(String[] args) {
        SingletonClass instance1 = SingletonClass.getInstance();
        SingletonClass instance2 = SingletonClass.getInstance();

        // Both instance1 and instance2 refer to the same object
        System.out.println(instance1 == instance2); // Output: true
    }
}
