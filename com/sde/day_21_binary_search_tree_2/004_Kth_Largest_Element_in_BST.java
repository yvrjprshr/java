package com.sde.day_21_binary_search_tree_2;

class Node
{
    int data;
    Node left;
    Node right;
    Node(int data)
    {
        this.data = data;
        left=null;
        right=null;
    }
}

class Solution
{

    public int cnt = 0, ans;
    
    public void dfs(Node root, int k){
        if(root == null) return;
        
        dfs(root.right, k);
        
        cnt++;
        
        if(cnt == k){
            ans = root.data;
        }
        
        dfs(root.left, k);
    }
    
    public int kthLargest(Node root,int K)
    {
        cnt = 0;
        dfs(root, K);
        return ans;
    }
}
