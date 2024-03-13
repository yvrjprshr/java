package com.yuvraj.collection;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

public class IteratorDemo {
    public static void main(String[] args) {
        Collection values = new ArrayList<>();
        values.add(2);
        values.add(3);
        values.add(4);

        Iterator it = values.iterator();
        while (it.hasNext()) {
            System.out.println(it.next());
        }
    }
}
