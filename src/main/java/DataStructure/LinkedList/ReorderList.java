package main.java.DataStructure.LinkedList;

/**
 * Created by Ryan on 4/1/18.
 */

/*
Given a singly linked list L: L0→L1→…→Ln-1→Ln,
reorder it to: L0→Ln→L1→Ln-1→L2→Ln-2→…

You must do this in-place without altering the nodes' values.

For example,
Given {1,2,3,4}, reorder it to {1,4,2,3}.
 */

/*
if(head==null||head.next==null) return;

//Find the middle of the list
ListNode p1=head;
ListNode p2=head;
while(p2.next!=null&&p2.next.next!=null){
    p1=p1.next;
    p2=p2.next.next;
}

//Reverse the half after middle  1->2->3->4->5->6 to 1->2->3->6->5->4
ListNode preMiddle=p1;
ListNode preCurrent=p1.next;
while(preCurrent.next!=null){
    ListNode current=preCurrent.next;
    preCurrent.next=current.next;
    current.next=preMiddle.next;
    preMiddle.next=current;
}

//Start reorder one by one  1->2->3->6->5->4 to 1->6->2->5->3->4
p1=head;
p2=preMiddle.next;
while(p1!=preMiddle){
    preMiddle.next=p2.next;
    p2.next=p1.next;
    p1.next=p2;
    p1=p2.next;
    p2=preMiddle.next;
}
 */
public class ReorderList {
    public void reorderList(ListNode head) {
        if (head==null||head.next==null||head.next.next==null) return;
        ListNode slow = head;
        ListNode fast = head;
        while (fast!=null&&fast.next!=null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        ListNode cur = slow.next;
        slow.next = null;
        while (cur!=null) {
            ListNode temp = cur.next;
            cur.next = slow;
            slow = cur;
            cur = temp;
        }
        fast = head;
        while (slow!=null) {
            ListNode fastTemp = fast.next;
            ListNode slowTemp = slow.next;
            fast.next = slow;
            slow.next = fastTemp;
            slow = slowTemp;
            fast = fastTemp;
        }
    }

    public static void main(String[] args) {
        ReorderList r = new ReorderList();
        ListNode ln = new ListNode(1);
        ln.next = new ListNode(2);
        ln.next.next = new ListNode(3);
        ln.next.next.next = new ListNode(4);
        ln.next.next.next.next = new ListNode(5);

        r.reorderList(ln);
        while (ln!=null) {
            System.out.println(ln.val);
            ln = ln.next;
        }
    }
}
