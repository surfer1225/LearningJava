package main.java.DataStructure.LinkedList;

/**
 * Created by Ryan on 30/12/17.
 */

/*
Write a program to find the node at which the intersection of two singly linked lists begins.


For example, the following two linked lists:

A:          a1 → a2
                   ↘
                     c1 → c2 → c3
                   ↗
B:     b1 → b2 → b3
begin to intersect at node c1.


Notes:

If the two linked lists have no intersection at all, return null.
The linked lists must retain their original structure after the function returns.
You may assume there are no cycles anywhere in the entire linked structure.
Your code should preferably run in O(n) time and use only O(1) memory.
 */
public class Intersection2Lists {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if (headA==null||headB==null) return null;
        ListNode tempA = headA;
        ListNode tempB = headB;

        int sizeA = 0;
        int sizeB = 0;
        while (tempA.next!=null) {
            tempA=tempA.next;
            sizeA++;
        }
        while (tempB.next!=null) {
            tempB=tempB.next;
            sizeB++;
        }
        if (sizeA < sizeB) {
            for (int i=0;i<Math.abs(sizeA-sizeB);i++) {
                headB = headB.next;
            }
        }
        else {
            for (int i=0;i<Math.abs(sizeA-sizeB);i++) {
                headA = headA.next;
            }
        }
        while (headA!=null) {
            if (headA.equals(headB)) return headA;
            headA=headA.next;
            headB=headB.next;
        }
        return null;
    }
}
