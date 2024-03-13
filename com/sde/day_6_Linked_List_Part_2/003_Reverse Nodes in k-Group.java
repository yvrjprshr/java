package com.sde.day_6_Linked_List_Part_2;

class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}

class Solution {
    public void reverseList(ListNode node){
        ListNode prev = null;
        ListNode curr = node;
        ListNode next = node.next;
        
        while(next != null){
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
    }
    public ListNode getKthNode(ListNode node, int k){
        k-= 1;
        while(node != null && k > 0){
            k--;
            node = node.next;
        }
        return node;
    }
    
    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode temp = head;
        ListNode prevLast = null;
        while(temp != null){
            ListNode kthNode = getKthNode(temp, k);
            
            if(kthNode == null){
                if(prevLast!=null) prevLast.next = temp;
                break;
            }
            
            ListNode nextNode = kthNode.next;
            kthNode.next = null;
            
            reverseList(temp);
            
            if(temp == head){
                head = kthNode;
            }else{
                prevLast.next = kthNode;
            }
            
            prevLast = temp;
            temp = nextNode;
        }
        
        return head;
    }
}