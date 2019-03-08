package main.java.DataStructure.LinkedList;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/*
382. Linked List Random Node

Given a singly linked list, return a random node's value from the linked list.
Each node must have the same probability of being chosen.

Follow up:
What if the linked list is extremely large and its length is unknown to you?
Could you solve this efficiently without using extra space?

Example:

// Init a singly linked list [1,2,3].
ListNode head = new ListNode(1);
head.next = new ListNode(2);
head.next.next = new ListNode(3);
Solution solution = new Solution(head);

// getRandom() should return either 1, 2, or 3 randomly. Each element should have equal probability of returning.
solution.getRandom();

 */
public class RandomLinkedList {
    /** reservoir sampling
     static void selectKItems(int stream[], int n, int k)
     {
     int i;   // index for elements in stream[]

     // reservoir[] is the output array. Initialize it with
     // first k elements from stream[]
     int reservoir[] = new int[k];
     for (i = 0; i < k; i++)
     reservoir[i] = stream[i];

     Random r = new Random();

     // Iterate from the (k+1)th element to nth element
     for (; i < n; i++)
     {
     // Pick a random index from 0 to i.
     int j = r.nextInt(i + 1);

     // If the randomly  picked index is smaller than k,
     // then replace the element present at the index
     // with new element from stream
     if(j < k)
     reservoir[j] = stream[i];
     }

     System.out.println("Following are k randomly selected items");
     System.out.println(Arrays.toString(reservoir));
     }
     */
    List<Integer> lis;
    /** @param head The linked list's head.
    Note that the head is guaranteed to be not null, so it contains at least one node. */
    public RandomLinkedList(ListNode head) {
        lis =new ArrayList<Integer>();
        while(head!=null){
            lis.add(head.val);
            head=head.next;
        }
    }

    /** Returns a random node's value. */
    public int getRandom() {
        Random rand=new Random();
        int rand_idx=rand.nextInt(lis.size());
        return lis.get(rand_idx);

    }

/**
 * Your Solution object will be instantiated and called as such:
 * Solution obj = new Solution(head);
 * int param_1 = obj.getRandom();
 */
}
