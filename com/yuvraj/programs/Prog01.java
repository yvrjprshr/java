package com.yuvraj.programs;

public class Prog01 {
    public static String reverse(String str){
        if(str==null)return str;
        StringBuilder s = new StringBuilder();
        char ch[] = str.toCharArray();
        for(int i=ch.length-1;i>=0;i--){
            s.append(ch[i]);
        }
        return s.toString();
    }
    public static void main(String[] args) {
        String str = "123";
        System.out.println(reverse(str));
    }
}