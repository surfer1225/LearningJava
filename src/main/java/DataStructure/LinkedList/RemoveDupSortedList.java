package main.java.DataStructure.LinkedList;

/**
 * Created by Ryan on 31/12/17.
 */

/*
Given a sorted linked list, delete all nodes that have duplicate numbers,
leaving only distinct numbers from the original list.

For example,
Given 1->2->3->3->4->4->5, return 1->2->5.
Given 1->1->1->2->3, return 2->3.


 */
public class RemoveDupSortedList {
    public ListNode deleteDuplicates(ListNode head) {
        if (head==null||head.next==null) return head;

        boolean isHeadSet = false;
        ListNode ln = head;
        ListNode prev = new ListNode(head.val-1);
        int val = prev.val;
        int cnt = 0;

        while (ln!=null) {
            if (ln.val!=val) {
                val = ln.val;
                if (cnt==1) {
                    prev = prev.next;
                    if (!isHeadSet) {
                        head = prev;
                        isHeadSet = true;
                    }
                }
                else {
                    prev.next = ln;
                }
                cnt = 1;
            }
            else {
                cnt++;
            }
            System.out.println("ln and prev: " + ln.val + ", " + prev.val);
            ln = ln.next;
        }
        if (cnt>1) prev.next = null;
        if (!isHeadSet) return cnt==1?prev.next:null;

        return head;
    }

    public static void main(String[] args) {
        ListNode h = new ListNode(0);
        h.next = new ListNode(1);
        h.next.next = new ListNode(1);
//        h.next.next.next = new ListNode(2);
//        h.next.next.next.next = new ListNode(3);
//        h.next.next.next.next.next = new ListNode(3);
//        h.next.next.next.next.next.next = new ListNode(4);
        RemoveDupSortedList r = new RemoveDupSortedList();
        h = r.deleteDuplicates(h);
        while (h!=null) {
            System.out.println(h.val);
            h=h.next;
        }
    }
}
