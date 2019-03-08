package main.java.DataStructure.LinkedList;

/**
 * Created by Ryan on 1/1/18.
 */

// Given a singly linked list, determine if it is a palindrome.
// Could you do it in O(n) time and O(1) space?
public class PalinedromeLinkedList {
    public boolean isPalindrome(ListNode head) {
        ListNode fast = head;
        ListNode slow = head;

        while(fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }
        if(fast != null) slow = slow.next;

        slow = reverse(slow);
        while(slow != null && head.val == slow.val) {
            head = head.next;
            slow = slow.next;
        }
        return slow == null;
    }

    private ListNode reverse(ListNode head) {
        ListNode prev = null;
        while(head != null) {
            ListNode next = head.next;
            head.next = prev;
            prev = head;
            head = next;
        }
        return prev;
    }

    public static void main(String[] args) {
        PalinedromeLinkedList p = new PalinedromeLinkedList();
        ListNode ln = new ListNode(0);
        ln.next = new ListNode(0);
        System.out.println(p.isPalindrome(ln));
    }
}
