package com.interview.linklist;

/**
 * http://www.geeksforgeeks.org/pairwise-swap-elements-of-a-given-linked-list/
 * Test case
 * odd or even number of k
 * odd or even number of nodes in the list
 */
public class ReverseKNodes {

    public Node reverse(Node head,int k){
        if(head == null){
            return null;
        }
        Node front = null;
        Node temp = head;
        Node end = null;
        int i=0;
        while(temp != null && i < k){
            end = temp.next;
            temp.next = front;
            front = temp;
            temp = end;
            i++;
        }
        head.next = reverse(temp,k);
        return front;
    }
    
    
    public static void main(String args[]){
        LinkList ll = new LinkList();
        Node head = null;
        head = ll.addNode(1, head);
        head = ll.addNode(2, head);
        head = ll.addNode(3, head);
        head = ll.addNode(4, head);
   
        ReverseKNodes rn = new ReverseKNodes();
        head = rn.reverse(head, 2);
        ll.printList(head);
    }
}
