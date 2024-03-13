package com.sde.day_14_Stack_and_Queue_part_2;

import java.util.*;

class Node{
    int key;
    int val;
    int freq = 1;
    Node next;
    Node prev;
    Node(int _key, int _value){
        key = _key;
        val = _value;
    }
}

class DoublyLinkedList{
    Node head;
    Node tail;

    DoublyLinkedList(){
        head = new Node(-1, -1);
        tail = new Node(-1, -1);

        head.next = tail;
        tail.prev = head;
    }

    void addNode(Node v){
        Node next = head.next;
        head.next = v;
        v.prev = head;
        v.next = next;
        next.prev = v;
    }

    Node remove(){
        Node node = tail.prev;
        node.prev.next = tail;
        tail.prev = node.prev;
        return node;
    }

    Node remove(Node v){
        Node prev_node = v.prev;
        Node next_node = v.next;
        prev_node.next = next_node;
        next_node.prev = prev_node;
        return v;
    }

    boolean isEmpty(){
        if(head.next == tail) return true;
        return false;
    }
}
class LFUCache {
    HashMap<Integer, DoublyLinkedList> freqList = new HashMap<>();
    HashMap<Integer, Node> lfuCache = new HashMap<>();
    int capacity;
    int minFreq;
    public LFUCache(int capacity) {
        this.capacity = capacity;
        minFreq = 1;
    }
    
    public int get(int key) {
        if(lfuCache.get(key) == null){
            return -1;
        }
        
        Node node = lfuCache.get(key);
        freqList.get(node.freq).remove(node);
        if(freqList.get(node.freq).isEmpty()){
            if(minFreq == node.freq){
                minFreq = node.freq+1;
            }
        }
        node.freq += 1;
        if(freqList.get(node.freq) == null){
            DoublyLinkedList new_dll = new DoublyLinkedList();
            new_dll.addNode(node);
            freqList.put(node.freq, new_dll);
        }else{
            freqList.get(node.freq).addNode(node);
        }
        return node.val;
    }
    
    public void put(int key, int value) {
        if(lfuCache.get(key) != null){
            Node node = lfuCache.get(key);
            freqList.get(node.freq).remove(node);
            if(freqList.get(node.freq).isEmpty()){
                if(minFreq == node.freq){
                    minFreq = node.freq+1;
                }
            }
            node.freq += 1;
            if(freqList.get(node.freq)==null){
                DoublyLinkedList dll = new DoublyLinkedList();
                dll.addNode(node);
                freqList.put(node.freq, dll);
            }else{
                freqList.get(node.freq).addNode(node);
            }
            node.val = value;
        }else{
            if(lfuCache.size() == capacity){
                Node v = freqList.get(minFreq).remove();
                lfuCache.remove(v.key);
            }
            Node newNode = new Node(key, value);
            lfuCache.put(key, newNode);
            if(freqList.get(1)==null){
                DoublyLinkedList dll = new DoublyLinkedList();
                dll.addNode(newNode);
                freqList.put(1, dll);
            }else{
                freqList.get(1).addNode(newNode);
            }
            minFreq = 1;
        }
    }
}

/**
 * Your LFUCache object will be instantiated and called as such:
 * LFUCache obj = new LFUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */