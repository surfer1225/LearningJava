package main.java.DataStructure.LinkedList;

/**
 * Created by Ryan on 27/12/17.
 */

/*
Given a sorted linked list, delete all duplicates such that each element appear only once.

For example,
Given 1->1->2, return 1->2.
Given 1->1->2->3->3, return 1->2->3.

 */
public class RemoveDuplicatesFromSortedList {
    public ListNode deleteDuplicates(ListNode head) {
        if (head==null) return null;
        if (head.next==null) return head;

        ListNode fast = head.next;
        ListNode slow = head;

        while (fast!=null) {
            if (fast.val==slow.val) {
                slow.next=fast.next;
            }
            else {
                slow=slow.next;
            }
            fast=fast.next;
        }
        return head;
    }
}
