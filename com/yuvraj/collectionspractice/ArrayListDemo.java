package com.yuvraj.collectionspractice;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

class CustomSort implements Comparator<Integer>{
    public int compare(Integer a, Integer b){
        if(a<b)return 1;
        return -1;
    }
}

public class ArrayListDemo {
    public static void main(String[] args) {
        List<Integer> lst = new ArrayList<>(Arrays.asList(1, 3, 4));
        lst.add(13);
        lst.add(12);
        lst.add(15);
        Collections.sort(lst, new CustomSort());
        System.out.println(lst);
    }
}
