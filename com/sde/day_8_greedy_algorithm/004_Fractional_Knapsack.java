package com.sde.day_8_greedy_algorithm;

import java.util.*;

class Item {
    int value, weight;
    Item(int x, int y){
        this.value = x;
        this.weight = y;
    }
}

class Solution
{
    //Function to get the maximum total value in the knapsack.
    class Comp implements Comparator<Item>{
        public int compare(Item a, Item b){
            double x = (double)a.value/(double)a.weight;
            double y = (double)b.value/(double)b.weight;
            if(x == y){
                return 0;
            }else if(x > y){
                return -1;
            }
            return 1;
        }
    }
    double fractionalKnapsack(int W, Item arr[], int n) 
    {
        // Your code here
        Comp comp = new Comp();
        Arrays.sort(arr, comp);
        double ans = 0;
        for(int i=0; i<n; i++){
            if(W>0){
                if(arr[i].weight <= W){
                    W -= arr[i].weight;
                    ans += arr[i].value;
                }else{
                    double single_unit = (double)arr[i].value/(double)arr[i].weight;
                    ans += single_unit * W;
                    W = 0;
                }
            }
        }
        return ans;
    }
}