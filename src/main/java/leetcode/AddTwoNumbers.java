package main.java.leetcode;

/**
 * Created by Ryan on 1/9/17.
 * You are given two non-empty linked lists representing two non-negative integers.
 * The digits are stored in reverse order and each of their nodes contain a single digit.
 * Add the two numbers and return it as a linked list.
 * You may assume the two numbers do not contain any leading zero, except the number 0 itself.
 */
class ListNode {
    int val;
    ListNode next;
    ListNode(int x) { val = x; next = null; }
}

public class AddTwoNumbers {

    private static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        int carry = 0;
        int digit;
        ListNode tempNode = null;
        while (l1 != null || l2 != null) {
            l1 = (l1 == null) ? new ListNode(0) : l1;
            l2 = (l2 == null) ? new ListNode(0) : l2;
            int temp = l1.val + l2.val + carry;
            digit = temp%10;
            carry = temp/10;
            ListNode nextNode = tempNode;
            tempNode = new ListNode(digit);
            tempNode.next = nextNode;
            System.out.println("l1, l2, digit: " + l1.val + ", " + l2.val + ", " + digit);
            l1 = l1.next;
            l2 = l2.next;
        }
        if (carry > 0) {
            ListNode nextNode = tempNode;
            tempNode = new ListNode(carry);
            tempNode.next = nextNode;
        }
        return tempNode;
    }

    private static void printList(ListNode l) {
        while (l != null) {
            System.out.println(l.val);
            l = l.next;
        }
    }

    public static void main(String[] args) {
        ListNode n1 = new ListNode(2);
        ListNode n2 = new ListNode(4);
        ListNode n3 = new ListNode(3);
        ListNode n4 = new ListNode(2);

        n1.next = n2;
        n2.next = n3;
        n3.next = n4;

        ListNode m1 = new ListNode(5);
        ListNode m2 = new ListNode(6);
        ListNode m3 = new ListNode(4);

        m1.next = m2;
        m2.next = m3;

        printList(addTwoNumbers(n1, m1));
    }
}
