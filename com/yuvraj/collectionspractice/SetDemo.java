package com.yuvraj.collectionspractice;

import java.util.HashSet;
import java.util.Set;
import java.util.Iterator;

public class SetDemo {
    public static void main(String[] args) {
        Set<Integer> st = new HashSet<>();
        st.add(4);
        st.add(1);
        st.add(5);
        st.add(3);
        st.add(2);
        st.add(1);

        Iterator<Integer> it = st.iterator();
        while(it.hasNext()){
            System.out.println(it.next());
        }
    }
}
