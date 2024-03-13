package com.yuvraj;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.Iterator;

class Tasks{
    // printing pattern
    public void task1(){
        System.out.println("Task 1");

        Scanner sc = new Scanner(System.in);
        System.out.println("Enter a Number: ");
        int n = sc.nextInt();
        sc.close(); 
        for(int i = 1; i <= n; i++){
            for(int j = 1; j <= n; j++){
                if(i == 1 || i == n){
                    System.out.print("*");
                }else {
                    if(j == 1 || j == n){
                        System.err.print("*");
                    }else{
                        System.out.print(" ");
                    }
                }
            }
            System.out.println();
        }
    }

    // printing 50 prime numbers
    public void task2(){
        System.out.println("Task 2");
        ArrayList<Integer> arr = new ArrayList<>();

        int num = 2;
        while (arr.size()<50) {
            boolean isok = true;
            for(int i=2; i<=num/2; i++){
                if(num%i==0)isok=false;
            }
            if(isok){
                arr.add(num);
            }
            num++;
        }
        Iterator<Integer> it = arr.iterator();

        while(it.hasNext()){
            System.out.print(it.next()+" ");
        }
    }

    // finding the 2nd max element
    public void task3(){
        
        System.out.println("Enter the size of array: ");
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        ArrayList<Integer>arr=new ArrayList<>(n);

        // taking input in array
        for(int i = 0; i < n; i++){
            int x = sc.nextInt();
            arr.add(x);
        }

        // it stores 1st max element
        int max_element = arr.get(0);
        // to check if there is only single element in array i.e. max element
        int max_element_cnt = 0;

        // finding the 1st max element
        for(int i = 0; i < arr.size(); i++){
            max_element = Math.max(max_element, arr.get(i));
        }

        int max_element2=0;

        // checking if there is single element else initialise max_element2 with an elment that is not max_element1
        for(int i = 0; i < arr.size(); i++){
            if(arr.get(i)==max_element)max_element_cnt++;
            else max_element2 = arr.get(i);
        }
        
        sc.close();

        // if there is only single max element
        if(max_element_cnt == arr.size()){
            System.out.println("\n2nd Max Element is: " + max_element);
            return;
        }
        
        // finding 2nd max element
        for(int i = 0; i < arr.size(); i++){
            if(arr.get(i)!=max_element){
                max_element2 = Math.max(max_element2, arr.get(i));
            }
        }
        System.out.println("\n2nd largest number in given array is : "+max_element2);
    }
}
public class App {
    public static void main(String[] args) throws Exception {
        Tasks obj = new Tasks();
        // obj.task1();
        // obj.task2();  
        obj.task3();
    }
}