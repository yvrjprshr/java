package com.sde.day_5_Linked_List;

class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}

class Solution {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        
        ListNode start = new ListNode();
        
        start.next = head;
        
        ListNode slowPtr = start;
        ListNode fastPtr = start;
        
        for(int i = 1; i <= n; i++){
            fastPtr = fastPtr.next;
        }
        
        while(fastPtr.next != null){
            slowPtr = slowPtr.next;
            fastPtr = fastPtr.next;
        }
        
        slowPtr.next = slowPtr.next.next;
        
        return start.next;
    }
}