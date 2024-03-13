package com.yuvraj.practice;

class Student{
    String name;
    int age;
    public Student(){
        name="student";
        age=18;
    }
    public Student(String name, int age){
        this.name=name;
        this.age=age;
    }
}
public class ArrayDemo {
    public static void main(String[] args) {
        // fixed size arrays
        int arr[] = new int[4];
        arr[0] = 2;
        arr[1] = 2;
        arr[2] = 2;
        arr[3] = 2;
        for(int x: arr){
            System.out.println(x);
        }
        for(int i = 0; i < arr.length; i++){
            System.out.println(arr[i]);
        }

        // another way
        int arr2[] = {1, 2, 3, 4, 4,5 , 6};
        for(int i = 0; i < arr2.length; i++){
            System.out.println(arr2[i]);
        }
        // Array of objects or user defined data types
        Student studArr[] = {new Student(), new Student("yuvraj", 22)};
        for(Student s: studArr){
            System.out.println(s.name + " -- "+s.age);
        }

        // 2d arrays and Jagged Arrays: not fixed size in each row
        int jaggedArray[][] = {
            {1, 2, 3, 4},
            {1, 2, 3},
            {1, 2, 3, 4, 5}
        };
        for(int i = 0; i < jaggedArray.length; i++){
            for(int j = 0; j < jaggedArray[i].length; j++){
                System.out.print(jaggedArray[i][j]+" ");
            }System.out.println();
        }

        int Array2d[][] = new int[3][4];
        for (int[] is : Array2d) {
            for (int is2 : is) {
                System.out.print(is2+" ");
            }System.out.println();
        }
    }
}
