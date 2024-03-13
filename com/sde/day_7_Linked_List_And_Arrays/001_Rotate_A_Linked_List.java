package com.sde.day_7_Linked_List_And_Arrays;

class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}

class Solution {
    public ListNode rotateRight(ListNode head, int k) {
        if(head == null || head.next == null) return head;
        int cnt = 0;
        
        ListNode temp = head;
        ListNode lastPtr = null;
        while(temp != null){
            cnt++;
            temp = temp.next;
            if(temp!=null){
                lastPtr = temp;
            }
        }
        k = k%cnt;
        
        if(k == 0) return head;
        
        int x = cnt-k;
        
        temp = head;
        
        for(int i = 1; i < x; i++){
            temp = temp.next;    
        }
        ListNode nextNode = temp.next;
        temp.next = null;
        lastPtr.next=head;
        return nextNode;
    }
}