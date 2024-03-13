package com.yuvraj.programs;

public class Prog04 {
    public static String removeWhiteSpaces(String str){
        StringBuilder sb = new StringBuilder();

        char ch[] = str.toCharArray();

        for(char c : ch){
            if(Character.isWhitespace(c)==false)sb.append(c);
        }

        return sb.toString();
    }
    public static void main(String[] args) {
        String x = "sdf sdfg dsg df gd ";
        System.out.println(removeWhiteSpaces(x));
    }
}
