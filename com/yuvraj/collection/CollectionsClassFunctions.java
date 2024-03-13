package com.yuvraj.collection;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class CollectionsClassFunctions {
    public static void main(String[] args) {
        List<Integer> lst = new ArrayList<>();
        lst.add(0, 12);
        lst.add(23);
        lst.add(230);
        lst.add(2903);
        lst.add(23);
        Collections.sort(lst);
        Collections.reverse(lst);
        System.out.println(lst);
    }
}
