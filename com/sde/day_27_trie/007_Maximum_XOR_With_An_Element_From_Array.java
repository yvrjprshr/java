package com.sde.day_27_trie;

import java.util.*;

class Node{
    Node links[] = new Node[2];
    
    boolean containsKey(int bit){
        return links[bit] != null;
    }
    
    Node get(int bit){
        return links[bit];
    }
    
    void put(int bit, Node node){
        links[bit] = node;
    }
}

class Trie{
    Node root;
    
    public Trie(){
        root = new Node();
    }
    
    void insert(int num){
        Node node = root;
        
        for(int i = 31; i >= 0; i--){
            int bit = (num >> i) & 1;
            if(node.containsKey(bit) == false){
                node.put(bit, new Node());
            }
            node = node.get(bit);
        }
    }
    
    int getMax(int num){
        Node node = root;
        int res = 0;
        
        for(int i = 31; i >= 0; i--){
            int bit = (num>>i) & 1;
            if(node.containsKey(1-bit) == false){
                node = node.get(bit);
            }else{
                res = (res | (1 << i));
                node = node.get(1-bit);
            }
        }
        
        return res;
    }
}

class Solution {
    
    class CustomComparator implements Comparator<ArrayList<Integer>>{
        public int compare(ArrayList<Integer> x, ArrayList<Integer> y){
            if(x.get(0) > y.get(0)){
                return 1;
            }else if(x.get(0) < y.get(0)){
                return -1;
            }else{
                return 0;
            }
        }
    }
    public int[] maximizeXor(int[] nums, int[][] queries) {
        int n = nums.length, q = queries.length;
        Arrays.sort(nums);
        ArrayList<ArrayList<Integer>> offlineQueries = new ArrayList<>();
        for(int i = 0; i < q; i++){
            ArrayList<Integer> temp = new ArrayList<>();
            temp.add(queries[i][1]);
            temp.add(queries[i][0]);
            temp.add(i);
            offlineQueries.add(temp);
        }
        CustomComparator cc = new CustomComparator();
        Collections.sort(offlineQueries, cc);
        Trie trie = new Trie();
        int ind = 0;
        int ans[] = new int[q];
        for(int i=0;i<q;i++){
            int limit = offlineQueries.get(i).get(0);
            int x = offlineQueries.get(i).get(1);
            int loc = offlineQueries.get(i).get(2);
            
            while(ind<n && nums[ind] <= limit){
                trie.insert(nums[ind]);
                ind++;
            }
            
            if(ind != 0){
                ans[loc] = trie.getMax(x);
            }else{
                ans[loc] = -1;
            }
        }
        
        return ans;
    }
}