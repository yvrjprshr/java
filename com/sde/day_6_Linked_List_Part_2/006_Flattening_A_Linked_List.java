package com.sde.day_6_Linked_List_Part_2;

class Node
{
	int data;
	Node next;
	Node bottom;
	
	Node(int d)
	{
		data = d;
		next = null;
		bottom = null;
	}
}

class GfG{
    public Node mergeTwoSortedLinkedList(Node a, Node b){
        Node res = new Node(0);
        Node curr = res;
        
        while(a!=null && b!=null){
            if(a.data < b.data){
                curr.bottom = a;
                a = a.bottom;
            }else{
                curr.bottom = b;
                b = b.bottom;
            }
            curr = curr.bottom;
        }
        
        if(a!=null){
            curr.bottom = a;
        }else if(b!=null){
            curr.bottom = b;
        }
        
        return res.bottom;
    }
    
    Node flatten(Node root){
        if(root == null || root.next == null){
            return root;
        }
        
        Node mergedHead = flatten(root.next);
        
        Node res = mergeTwoSortedLinkedList(root, mergedHead);
        
        return res;
    }
}