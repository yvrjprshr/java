package com.sde.day_7_Linked_List_And_Arrays;

class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}

class Solution {
    public Node copyRandomList(Node head) {
        Node temp = head;
        
        // step 1 -> add copy node infront of each node
        while(temp != null){
            Node newNode = new Node(temp.val);
            newNode.next = temp.next;
            temp.next = newNode;
            temp = temp.next.next;
        }
        
        // step 2 -> set random pointer
        Node itr = head;
        while(itr != null){
            if(itr.random != null){
                itr.next.random = itr.random.next;
            }
            itr = itr.next.next;
        }
        
        // step 3 -> separate copied and actual linked list
        Node dummyNode = new Node(0);
        
        
        itr = head; // holds actual list
        temp = dummyNode; // holds copied list
        Node fast;
        while(itr!=null){
            fast=itr.next.next; // holds next node of actual list
            temp.next = itr.next; 
            itr.next = fast; 
            temp = temp.next;
            itr = fast;
        }
        
        return dummyNode.next;
    }
}