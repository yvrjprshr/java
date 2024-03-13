package com.yuvraj.comparatorinterface;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

class CustomObject{
    public int id;
    public String name;

    public CustomObject(int a, String b){id=a;name=b;}

    static class CustomComparator implements Comparator<CustomObject>{
        @Override
        public int compare(CustomObject a, CustomObject b){
            if(a.id > b.id)return -1;
            return 1;
        }
    }

    public String toString(){
        return this.id+"->"+this.name;
    }
}

public class Demo {
    public static void main(String[] args) {
        List<CustomObject> lst = new ArrayList<>();
        lst.add(new CustomObject(1, "yuvraj"));   
        lst.add(new CustomObject(5, "devraj"));   
        lst.add(new CustomObject(3, "devraj"));   
        lst.add(new CustomObject(2, "devraj"));   
        lst.add(new CustomObject(8, "devraj"));
        
        Collections.sort(lst, new CustomObject.CustomComparator());

        for(CustomObject obj: lst){
            System.out.println(obj);
        }
    }
}
