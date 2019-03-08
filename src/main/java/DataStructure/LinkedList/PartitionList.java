package main.java.DataStructure.LinkedList;

/**
 * Created by Ryan on 4/1/18.
 */

/*
Given a linked list and a value x,
partition it such that all nodes less than x come before nodes greater than or equal to x.

You should preserve the original relative order of the nodes in each of the two partitions.

For example,
Given 1->4->3->2->5->2 and x = 3,
return 1->2->2->4->3->5.
 */
public class PartitionList {
    public ListNode partition(ListNode head, int x) {
        if (head==null||head.next==null) return head;
        ListNode smaller = new ListNode(-1);
        ListNode bigger = new ListNode(-1);
        ListNode biggerPrehead = bigger;
        ListNode smallerPrehead = smaller;
        smaller.next = head;
        ListNode cur = head;
        System.out.println("cur.next: "+cur.next.val);
        while (cur!=null) {
            System.out.println("cur: " + cur.val);
            if (cur.val>=x) {
                bigger.next = cur;
                bigger = bigger.next;
                smaller.next = cur.next;
                cur.next = null;
                cur = smaller.next;
            }
            else {
                cur = cur.next;
                smaller = smaller.next;
            }
        }
        smaller.next = biggerPrehead.next;
        return smallerPrehead.next;
    }

    public static void main(String[] args) {
        System.out.println("executing:....");
        PartitionList p = new PartitionList();
        ListNode ln = new ListNode(1);
        ln.next = new ListNode(4);
        ln.next.next = new ListNode(3);
        ln.next.next.next = new ListNode(2);
        ln.next.next.next.next = new ListNode(5);
        ln.next.next.next.next.next = new ListNode(2);
        ln = p.partition(ln, 3);
        while (ln!=null) {
            System.out.println(ln.val);
            ln = ln.next;
        }
    }
}
