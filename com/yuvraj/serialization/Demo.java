package com.yuvraj.serialization;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.Serializable;

class Person implements Serializable {
    private String name;
    private int age;

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    // Getters and setters...
}
public class Demo {
    public static void main(String[] args) {
        // Create a Person object
        Person person = new Person("John", 30);

        // Serialize the object to a file
        try (FileOutputStream fileOut = new FileOutputStream("person.ser");
             ObjectOutputStream objOut = new ObjectOutputStream(fileOut)) {
            objOut.writeObject(person);
            System.out.println("Object serialized successfully.");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
