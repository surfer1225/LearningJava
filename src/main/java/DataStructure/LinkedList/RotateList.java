package main.java.DataStructure.LinkedList;

/**
 * Created by Ryan on 31/12/17.
 */

/*
Given a list, rotate the list to the right by k places, where k is non-negative.


Example:

Given 1->2->3->4->5->NULL and k = 2,

return 4->5->1->2->3->NULL.
 */

public class RotateList {
    public ListNode rotateRight(ListNode head, int k) {
        if (head==null || head.next==null) return head;
        ListNode temp = head;
        int size = 1;
        while (temp.next!=null) {
            temp = temp.next;
            size++;
        }
        k%=size;
        System.out.println("size, k: " + size + ", " +k);
        temp.next = head;
        ListNode slow = head;
        ListNode fast = head;
        for (int i=0;i<k;i++) fast=fast.next;
        while (!fast.next.equals(head)) {
            fast = fast.next;
            slow = slow.next;
        }
        head = slow.next;
        slow.next = null;
        return head;
    }
}
