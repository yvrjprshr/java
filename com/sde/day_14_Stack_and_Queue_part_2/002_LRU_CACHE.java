package com.sde.day_14_Stack_and_Queue_part_2;
import java.util.*;
class LRUCache {
    Node head, tail;
    int capacity;
    Map<Integer, Node> hmap;
    public LRUCache(int capacity) {
        head = new Node(0, 0);
        tail = new Node(0, 0);
        head.next = tail;
        tail.prev = head;
        hmap = new HashMap<>();
        this.capacity = capacity;
    }
    
    public int get(int key) {
        if(hmap.containsKey(key)){
            Node node = hmap.get(key);
            remove(node);
            insert(node);
            return node.value;
        }
        return -1;
    }
    
    public void put(int key, int value) {
        if(hmap.containsKey(key)){
            remove(hmap.get(key));
            capacity++;
        }else if(capacity == 0){
            remove(tail.prev);
            capacity++;
        }
        insert(new Node(key, value));
        capacity--;
    }
    
    public void remove(Node node){
        node.prev.next = node.next;
        node.next.prev = node.prev;
        hmap.remove(node.key);
    }
    
    public void insert(Node node){
        hmap.put(node.key, node);
        node.next = head.next;
        node.next.prev = node;
        head.next = node;
        node.prev = head;
    }
    
    class Node{
        Node prev, next;
        int key, value;
        Node(int _key, int _value){
            key = _key;
            value = _value;
        }
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */