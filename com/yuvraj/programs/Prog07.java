package com.yuvraj.programs;

import java.util.Scanner;

class Practice {
    public void printString() {
        String str;
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter String...");
        str = sc.next();
        System.out.println(str);
    }

    public void findStringLength(){
        String s = "wsdfsdfsdf";
        System.out.println(s.length());
    }

    public void compareTwoStrings(){
        String s = "dsfsdb";
        String t = "dsfsda";
        System.out.println(s.compareTo(t));
    }

    public void printAllSubstrings(){
        String s = "yuvraj";
        for(int i=0;i<s.length();i++){
            for(int j=0;j<=i;j++){
                System.out.println(i + " " + j+1);
                System.out.println(s.substring(j,i+1));
            }
        }
    }

    public void reverseString(){
        String s = "yuvraj";
        String rev = "";
        StringBuilder sb = new StringBuilder(s);
        // for(int i = s.length()-1; i>=0; i--)rev+=s.charAt(i);
        int i = 0, j = sb.length()-1;
        while(i<=j){
            char x = sb.charAt(i);
            sb.setCharAt(i, sb.charAt(j));
            sb.setCharAt(j, x);
            i++;j--;
        }
        System.out.println(sb);
    }
}

public class Prog07 {

    public static void main(String[] args) {
        Practice obj = new Practice();
        // obj.printString();
        // obj.findStringLength();
        // obj.compareTwoStrings();
        // obj.printAllSubstrings();
        obj.reverseString();
    }
}
