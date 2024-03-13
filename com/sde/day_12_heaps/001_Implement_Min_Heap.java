package com.sde.day_12_heaps;

import java.util.* ;

class Solution {

    // minHeap function which take size of Queries and Queries as Input.
    // Returns an array out outputs depending on the query.

    // Implemented using complete Binary Search Tree 
    static int[] minHeap(int n, int[][] q) {
        // Write your code here.
        List<Integer> ansList = new ArrayList<>();
        ArrayList<Integer> heapArrayList = new ArrayList<>();

        for(int i = 0; i < q.length; i++){
            int x = q[i][0];

            if(x == 0){
                insertIntoHeapArrayList(heapArrayList, q[i][1]);
            }else{
                int res = findAndRemoveMin(heapArrayList);
                ansList.add(res);
            }
        }

        int ansArray[] = new int[ansList.size()];
        for(int i = 0; i < ansArray.length; i++) ansArray[i] = ansList.get(i);
        return ansArray;
    }

    static void insertIntoHeapArrayList(ArrayList<Integer> heapArrayList, int x){
        heapArrayList.add(x);
        int index = heapArrayList.size()-1;

        while(index!=0){
            int parent = Math.floorDiv(index-1, 2);
            if(heapArrayList.get(parent) > heapArrayList.get(index)){
                int temp = heapArrayList.get(parent);
                heapArrayList.set(parent, heapArrayList.get(index));
                heapArrayList.set(index, temp);
                index = parent;
            }else{
                break;
            }
        }
    }

    static int findAndRemoveMin(ArrayList<Integer> heapArrayList){
        if(heapArrayList.size() == 0) return -1;

        int min = heapArrayList.get(0);
        heapArrayList.set(0, heapArrayList.get(heapArrayList.size()-1));
        heapArrayList.remove(heapArrayList.size()-1);
        int n = heapArrayList.size();
        int index = 0;

        while(index < n){
            int leftChild = 2*index + 1;
            int rightChild = 2*index + 2;

            int smallerIndex = index;

            if(leftChild < n && heapArrayList.get(leftChild) < heapArrayList.get(index)){
                smallerIndex = leftChild;
            }

            if(rightChild < n && heapArrayList.get(rightChild) < heapArrayList.get(smallerIndex)){
                smallerIndex = rightChild;
            }

            if(smallerIndex != index){
                int temp = heapArrayList.get(index);
                heapArrayList.set(index, heapArrayList.get(smallerIndex));
                heapArrayList.set(smallerIndex, temp);
                index = smallerIndex;
            }else{
                break;
            }
        }

        return min;
    }
}