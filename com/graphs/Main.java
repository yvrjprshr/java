package com.graphs;

// Source: https://usaco.guide/general/io

import java.io.*;
import java.util.StringTokenizer;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
	

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        Integer x = sc.nextInt();
        
        ArrayList<Integer>arr= new ArrayList<>();

        while(x>0){
            arr.add(x%10);
            x = x/10;
        }

        boolean ok = true;

        for(int i = 1; i < arr.size(); i++){
            if(arr.get(i-1)>=arr.get(i)){
                ok = false;
            }
        }

        if(ok == true){
            System.out.println("Yes");
        }else{
            System.out.println("No");
        }

        sc.close();
    }
}
