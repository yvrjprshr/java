package com.sde.day_8_greedy_algorithm;

import java.util.*;

class Solution 
{
    //Function to find the maximum number of meetings that can
    //be performed in a meeting room.
    static class Meeting{
        int start;
        int end;
        int pos;
        Meeting(int start, int end, int pos){
            this.start = start;
            this.end = end;
            this.pos = pos;
        }
    }
    public static class CompareMeeting implements Comparator<Meeting>{
        @Override
        public int compare(Meeting m1, Meeting m2){
            if(m1.end > m2.end){
                return 1;
            }else if(m1.end < m2.end){
                return -1;
            }else if(m1.pos < m2.pos){
                return -1;
            }
            return 1;
        }
    }
    public static int maxMeetings(int start[], int end[], int n)
    {
        ArrayList<Meeting> arr = new ArrayList<>();
        for(int i = 0; i < start.length; i++){
            arr.add(new Meeting(start[i], end[i], i+1));
        }
        CompareMeeting cm = new CompareMeeting();
        Collections.sort(arr, cm);
        int cnt = 1;
        int limit = arr.get(0).end;
        for(int i = 1; i < arr.size(); i++){
            if(arr.get(i).start > limit){
                limit = arr.get(i).end;
                cnt++;
            }
        }
        return cnt;
    }
}