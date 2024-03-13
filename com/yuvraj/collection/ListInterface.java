package com.yuvraj.collection;

import java.util.ArrayList;
import java.util.List;

public class ListInterface {
    public static void main(String[] args) {
        List values = new ArrayList<>();

        values.add(2);
        values.add(3);
        values.add(42);
        values.add(62);
        values.add("radhe");

        values.add(1, 90);
        // values.add(1, 99);

        values.remove(2);
        System.out.println(values);

        for(int i = 0; i < values.size(); i++){
            System.out.println("hey " + values.get(i));
        }

        // for(Object o : values){
            // System.out.println("hola " + o);
        // }
    }
}
