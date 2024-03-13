package com.yuvraj.collection;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class MapInterface {
    public static void main(String[] args) {
        Map<Integer, String> mp = new HashMap<>();

        mp.put(1, "yuvi");
        mp.put(2, "yuvika");

        Set<Integer> st = mp.keySet();

        for(Integer x: st){
            System.out.println(mp.get(x));
        }
    }
}
