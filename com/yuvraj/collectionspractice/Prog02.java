package com.yuvraj.collectionspractice;

import java.util.ArrayList;
import java.util.List;

public class Prog02 {
    public static void main(String[] args) {
        List<Integer> lst = new ArrayList<>();

        lst.add(12);
        lst.add(13);
        lst.add(15);
        lst.add(16);

        Integer arr []= lst.toArray(new Integer[lst.size()]);
        for(Integer x: arr){
            System.out.println(x);
        }
    }
}
