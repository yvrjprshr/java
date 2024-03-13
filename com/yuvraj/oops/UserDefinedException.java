package com.yuvraj.oops;

class YuvrajException extends Exception {
    public YuvrajException(String s) {
        super(s);
    }
}

public class UserDefinedException {
    public static void main(String[] args) {
        try{
            int k = 1;
            if(k == 0){
                throw new YuvrajException("Don't Put Zero there");
            }
        }catch(YuvrajException e){
            System.out.println(e);
        }finally{
            System.out.println("flow....");
        }
    }
}
