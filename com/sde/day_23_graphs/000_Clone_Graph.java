package com.sde.day_23_graphs;

import java.util.*;

class Node {
    public int val;
    public List<Node> neighbors;
    public Node() {
        val = 0;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val) {
        val = _val;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val, ArrayList<Node> _neighbors) {
        val = _val;
        neighbors = _neighbors;
    }
}

class Solution {
    public Node dfs(Node node, HashMap<Node, Node> hmap){
        if(node == null) return null;
        if(hmap.containsKey(node)) return hmap.get(node);
        Node copyNode = new Node(node.val);
        hmap.put(node, copyNode);
        for(Node neighbor : node.neighbors){
            copyNode.neighbors.add(dfs(neighbor, hmap));
        }
        return copyNode;
    }
    
    public Node cloneGraph(Node node) {
        if(node == null) return node;
        HashMap<Node, Node> hmap = new HashMap<>();
        return dfs(node, hmap);
    }
}