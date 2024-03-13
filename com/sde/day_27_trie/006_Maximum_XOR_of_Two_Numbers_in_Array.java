package com.sde.day_27_trie;
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
            int bit = (num>>i) & 1;
            if(node.containsKey(bit)==false){
                node.put(bit, new Node());
            }
            node = node.get(bit);
        }
    }
    
    int getMax(int num){
        Node node = root;
        
        int maxRes = 0;
        
        for(int i = 31; i >= 0; i--){
            int bit = (num >> i) & 1;
            
            if(node.containsKey(1-bit)){
                maxRes = maxRes | (1 << i);
                node = node.get(1-bit);
            }else{
                node = node.get(bit);
            }
        }
        
        return maxRes;
    }
}

class Solution {
    public int findMaximumXOR(int[] nums) {
        Trie trie = new Trie();
        
        for(int i = 0; i < nums.length; i++){
            trie.insert(nums[i]);
        }
        
        int maxi = 0;
        
        for(int i = 0; i < nums.length; i++){
            maxi = Math.max(maxi, trie.getMax(nums[i]));
        }
        
        return maxi;
    }
}