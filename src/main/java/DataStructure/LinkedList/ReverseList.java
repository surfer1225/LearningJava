package main.java.DataStructure.LinkedList;

/**
 * Created by Ryan on 1/1/18.
 */

//Reverse a singly linked list.
public class ReverseList {
    public ListNode reverseList(ListNode head) {
        if (head==null||head.next==null) return head;
        ListNode ln = head.next;
        head.next = null;
        while (ln != null) {
            ListNode temp = ln.next;
            ln.next = head;
            head = ln;
            ln = temp;
        }
        return head;
    }

    public static void main(String[] args) {
        ListNode h = new ListNode(1);
        h.next = new ListNode(2);
        ReverseList r = new ReverseList();
        h = r.reverseList(h);
        while (h!=null) {
            System.out.println(h.val);
            h = h.next;
        }
    }
}
