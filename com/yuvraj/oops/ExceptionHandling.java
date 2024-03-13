package com.yuvraj.oops;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class ExceptionHandling {
    public static void main(String[] args) throws Exception{
        // unchekced Exception
        try {
            int a = 2;
            int b = 0;
            System.out.println(a / b);
        } catch (ArithmeticException e) {
            System.err.println(e);
        } catch (Exception e) {
            System.err.println(e);
        } finally {
            System.out.println("runs always");
        }
        System.out.println("running furter");




        // checed Exception
        BufferedReader br  = null;
        int n;
        try{
            br = new BufferedReader(new InputStreamReader(System.in));
            n = Integer.parseInt(br.readLine());
        }catch(Exception e){
            System.out.println(e);
        }finally{
            br.close();
        }
        

    }
}
