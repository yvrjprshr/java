package com.yuvraj.programs;

public class Prog02 {
    public static void printFib(int cnt){
        int a = 0;
        int b = 1;
        int c = 1;
        for(int i=1;i<=cnt;i++){
            System.out.println(a+" ");
            a = b;
            b = c;
            c = a+b;
        }
    }

    public static int printFibRec(int cnt){
        if(cnt<=1){
            return cnt;
        }
        return printFibRec(cnt-1)+printFibRec(cnt-2);
    }

    public static void main(String[] args) {
        // printFib(10);
        // printFibRec(3);
        int x = 10;
        for(int i=1;i<=x;i++){
            System.out.println(printFibRec(i));
        }
    }
}
