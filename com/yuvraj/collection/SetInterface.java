package com.yuvraj.collection;

import java.util.HashSet;
import java.util.Set;
import java.util.TreeSet;

public class SetInterface {
    public static void main(String[] args) {
        Set<Integer> st = new HashSet<>();
        st.add(23);
        st.add(24);
        st.add(25);
        st.add(23);
        System.out.println(st);


        Set<Integer> treeSt = new TreeSet<>();
        treeSt.add(23);
        treeSt.add(24);
        treeSt.add(25);
        treeSt.add(23);
        System.out.println(treeSt);
    }
}
