package main.java.Company.Facebook;

import java.util.Comparator;
import java.util.PriorityQueue;

public class MergeKLists {
    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    public ListNode mergeKLists(ListNode[] lists) {
        if (lists == null || lists.length == 0) return null;
        PriorityQueue<ListNode> pq = new PriorityQueue<>(Comparator.comparing(l -> l.val));

        for (ListNode ln : lists) {
            if (ln!=null) pq.add(ln);
        }

        ListNode head = new ListNode(-1);
        ListNode cur = head;

        while (!pq.isEmpty()) {
            cur.next = pq.poll();
            cur = cur.next;
            if (cur.next != null) pq.add(cur.next);
        }

        return head.next;
    }
}
