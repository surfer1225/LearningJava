package main.java.DataStructure.LinkedList;

/**
 * Created by Ryan on 27/12/17.
 */

//Sort a linked list in O(n log n) time using constant space complexity.
public class SortList {
    public ListNode sortList(ListNode head) {
        if (head==null||head.next==null) return head;
        ListNode mid = getMid(head);
        ListNode tempMid = mid.next;
        mid.next = null;
        head = sortList(head);
        tempMid = sortList(tempMid);
        System.out.println(head.val+","+tempMid.val);
        return mergeTwoLists(head,tempMid);
    }

    private ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        // maintain an unchanging reference to node ahead of the return node.
        ListNode prehead = new ListNode(-1);

        ListNode prev = prehead;
        while (l1 != null && l2 != null) {
            if (l1.val <= l2.val) {
                prev.next = l1;
                l1 = l1.next;
            } else {
                prev.next = l2;
                l2 = l2.next;
            }
            prev = prev.next;
        }

        // exactly one of l1 and l2 can be non-null at this point, so connect
        // the non-null list to the end of the merged list.
        prev.next = l1 == null ? l2 : l1;

        return prehead.next;
    }

    private ListNode getMid(ListNode n) {
        ListNode prehead = new ListNode(-1);
        prehead.next = n;
        ListNode fast = prehead;
        ListNode slow = prehead;
        while (fast!=null&&fast.next!=null) {
            slow=slow.next;
            fast=fast.next.next;
        }
        return slow;
    }

    public static void main(String[] args) {
        SortList s = new SortList();
        ListNode ln = new ListNode(2);
        ln.next = new ListNode(1);
//        ln.next.next = new ListNode(2);
//        ln.next.next.next = new ListNode(5);
        ln = s.sortList(ln);
        while (ln!=null) {
            System.out.println(ln.val);
            ln = ln.next;
        }
    }
}
