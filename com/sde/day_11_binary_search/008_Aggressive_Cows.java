package com.sde.day_11_binary_search;

import java.util.*;

class Main {   
    public static Scanner sc;
    public static boolean isValid(ArrayList<Integer> arr, int cows, int distance){
        int cnt = 1;
        int prev = arr.get(0);
        for(int i=1; i<arr.size(); i++){
            if(arr.get(i)-prev >= distance){
                cnt++;
                prev = arr.get(i);
            }
        }
        if(cnt >= cows){
            return true;
        }

        return false;
    }

    public static void tc(){
        int n = sc.nextInt();
        int c = sc.nextInt();
        ArrayList<Integer> arr = new ArrayList<>();
        for(int i=0;i<n;i++){
            arr.add(sc.nextInt());
        }
        Collections.sort(arr);
        int left = 0;
        int right = arr.get(arr.size()-1) - arr.get(0) + 1;
        while(right-left > 1){
            int mid = left + (right-left)/2;
            if(isValid(arr, c, mid)){
                left = mid;
            }else{
                right = mid;
            }
        }

        System.out.println(left);
    }
    public static void main(String[] args){
        sc = new Scanner(System.in);
        int n = sc.nextInt();
        while(n-->0){
            tc();
        }
    }
}
