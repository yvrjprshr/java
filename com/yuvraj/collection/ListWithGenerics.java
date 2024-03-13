package com.yuvraj.collection;

import java.util.ArrayList;
import java.util.List;

public class ListWithGenerics {
    public static void main(String[] args) {
        List<Integer> lst = new ArrayList<>();
        lst.add(0, 12);
        lst.add(23);
        lst.add(230);
        lst.add(2903);
        lst.add(23);
        System.out.println(lst);
    }
}
