package com.sde.day_6_Linked_List_Part_2;

class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}
class Solution {
    
    public ListNode reverseList(ListNode node){
        ListNode prev = null;
        ListNode curr = node;
        ListNode next = node.next;
        
        while(next!=null){
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        
        return prev !=null ? prev : curr;
    }
    public boolean isPalindrome(ListNode head) {
        
        if(head==null || head.next==null) return true;
        
        ListNode slowPtr = head;
        ListNode fastPtr = head;
        
        while(fastPtr.next!=null && fastPtr.next.next!=null){
            slowPtr = slowPtr.next;
            fastPtr = fastPtr.next.next;
        }
        
        slowPtr.next = reverseList(slowPtr.next);
        
        slowPtr = slowPtr.next;
        
        ListNode startingPtr = head;
        
        while(slowPtr != null){
            if(slowPtr.val != startingPtr.val) return false;
            slowPtr = slowPtr.next;
            startingPtr = startingPtr.next;
        }
        
        return true;
    }
}