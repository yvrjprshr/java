package com.sde.day_2_arrays_2;

class Solution {
    public static int cnt = 0;
    public static void merge(long arr[], int st, int mid, int en){
        int sz = en-st+1;
        long temp[] = new long[sz];
        int pt1 = st;
        int pt2 = mid+1;
        int pt3 = 0;
        while(pt1<=mid && pt2<=en){
            if(arr[pt1] <= arr[pt2]){
                temp[pt3] = arr[pt1];
                pt1++;
            }else{
                temp[pt3] = arr[pt2];
                cnt += (mid-pt1+1);
                pt2++;
            }
            pt3++;
        }         
        while(pt1<=mid){
            temp[pt3] = arr[pt1];
            pt1++;
            pt3++;
            // cnt += mid/
        }
        while(pt2<=en){
            temp[pt3] = arr[pt2];
            pt2++;
            pt3++;
            // cnt += (mid-st);
        }

        pt3 = 0;
        while(st<=en){
            arr[st]=temp[pt3];
            st++;
            pt3++;
        }
    }

    public static void mergeSort(long arr[], int st, int en){
        if(st >= en ) return;
        int mid = (st+en)/2;
        mergeSort(arr, st, mid);
        mergeSort(arr, mid+1, en);
        merge(arr, st, mid, en);
    }

    public static long getInversions(long arr[], int n) {
        // Write your code here.
        mergeSort(arr, 0, n-1);
        return cnt;
    }
}