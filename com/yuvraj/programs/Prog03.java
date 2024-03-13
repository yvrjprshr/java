package com.yuvraj.programs;

public class Prog03 {

    public static boolean isPal(String str){
        int i = 0, j = str.length()-1;
        while(i<=j){
            if(str.charAt(i)!=str.charAt(j)){
                return false;
            }i++;j--;
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(isPal("xyx"));  
    }
}