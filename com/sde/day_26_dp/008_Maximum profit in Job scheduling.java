package com.sde.day_26_dp;
import java.util.*;
class Solution
{
    class Job {
        int id, profit, deadline;
        Job(int x, int y, int z){
            this.id = x;
            this.deadline = y;
            this.profit = z; 
        }
    }
    
    //Function to find the maximum profit and the number of jobs done.
    class Comp implements Comparator<Job>{
        public int compare(Job j1, Job j2){
            if(j1.profit > j2.profit) return -1;
            if(j2.profit > j1.profit) return 1;
            return 0;
        }
    }
    int[] JobScheduling(Job arr[], int n)
    {
        Comp comp = new Comp();
        Arrays.sort(arr, comp);
        int maxDeadline = 0;
        for(int i = 0; i < n; i++){
            maxDeadline = Math.max(maxDeadline, arr[i].deadline);
        }
        int vis[] = new int[maxDeadline+1];
        int cnt = 0;
        int profit = 0;
        for(int i = 0; i < n; i++){
            int target = arr[i].deadline;
            while(target > 0 && vis[target]==1)target--;
            if(target!=0){
                vis[target]=1;
                profit += arr[i].profit;
                cnt++;
            }
        }
        int ans[] = new int[2];
        ans[0] = cnt;
        ans[1] = profit;
        return ans;
    }
}