package com.sde.day_8_greedy_algorithm;

import java.util.*;

class Job {
    int id, profit, deadline;
    Job(int x, int y, int z){
        this.id = x;
        this.deadline = y;
        this.profit = z; 
    }
}

class Solution
{
    //Function to find the maximum profit and the number of jobs done.
    class Comp implements Comparator<Job>{
        public int compare(Job a, Job b){
            if(a.profit == b.profit){
                return 0;
            }else if(a.profit > b.profit){
                return -1;
            }
            return 1;
        }
    }
    int[] JobScheduling(Job arr[], int n)
    {
        Comp cObj = new Comp();
        Arrays.sort(arr, cObj);
        int maxi = Integer.MIN_VALUE;
        for(int i=0; i<n; i++){
            maxi = Math.max(maxi, arr[i].deadline);
        }
        int[] vis = new int[maxi+1];
        Arrays.fill(vis, -1);
        int cnt = 0;
        int prof = 0;
        for(int i=0; i<n; i++){
            int curr = arr[i].deadline;
            while(curr >= 1 && vis[curr]!=-1){
                curr--;
            }
            if(curr != 0){
                vis[curr]=1;
                prof += arr[i].profit;
                cnt++;
            }
        }
        int ans[] = new int[2];
        ans[0] = cnt;
        ans[1] = prof;
        return ans;
    }
}