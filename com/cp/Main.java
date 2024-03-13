package com.cp;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    static Scanner sc = new Scanner(System.in);
    public static void findAllStrings(int i, int n, int limit, String str, ArrayList<String> arr){
        if(str.length()==limit) {
            arr.add(str);
            return;
        }

        str += ('a'+i);
        findAllStrings(i+1);
    }
    public static void solvetc(){
        int n = sc.nextInt();
        int k = sc.nextInt();
        int sz = sc.nextInt();
        String str = sc.next();
        ArrayList<String> arr = new ArrayList<>();
        String temp = "";
        findAllStrings(0, n, temp, arr);
    }
    public static void main(String[] args) {
        int t = sc.nextInt();
        while(t-->0){
            solvetc();
        }
    }
}
