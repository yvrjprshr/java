package com.sde.day_6_Linked_List_Part_2;

class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}

class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        ListNode ln1 = headA;
        ListNode ln2 = headB;
        
        while(ln1 != ln2){
            if(ln1 == null) ln1 = headB;
            else ln1 = ln1.next;
            
            if(ln2 == null) ln2 = headA;
            else ln2 = ln2.next;
        }
        
        return ln1;
    }
}