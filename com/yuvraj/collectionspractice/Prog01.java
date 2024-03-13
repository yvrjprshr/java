package com.yuvraj.collectionspractice;

import java.util.ArrayList;
import java.util.List;

public class Prog01 {
    public static void main(String[] args) {
        List<Integer> lst = new ArrayList<>();

        lst.add(12);
        lst.add(13);
        lst.add(15);
        lst.add(16);

        // for(int i=0; i<lst.size(); i++)System.out.println(lst.get(i));
        // for(int o : lst){System.out.println(o);}
        // for(Integer o : lst){System.out.println(o);}
        // for(Object o : lst){System.out.println(o);}
        // lst.forEach(e->System.out.println(e));
    }
}
