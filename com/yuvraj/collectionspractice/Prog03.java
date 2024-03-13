package com.yuvraj.collectionspractice;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class Prog03 {
    public static void main(String[] args) {
        Set<Integer> st = new HashSet<>();
        st.add(12);
        st.add(12);
        st.add(12);
        st.add(12);
        st.add(13);
        System.out.println(st);
        for(Integer i : st){
            System.out.println(i);
        }
        Iterator<Integer> it =  st.iterator();
        while (it.hasNext()) {
            System.out.println(it.next());
        }
    }
}
