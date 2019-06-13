package main.java.leetcode.RevisionQns;

import java.util.*;

/*
703. Kth Largest Element in a Stream

Design a class to find the kth largest element in a stream.
Note that it is the kth largest element in the sorted order, not the kth distinct element.

Your KthLargest class will have a constructor which accepts an integer k and an integer array nums,
which contains initial elements from the stream. For each call to the method KthLargest.add,
return the element representing the kth largest element in the stream.

Example:

int k = 3;
int[] arr = [4,5,8,2];
KthLargest kthLargest = new KthLargest(3, arr);
kthLargest.add(3);   // returns 4
kthLargest.add(5);   // returns 5
kthLargest.add(10);  // returns 5
kthLargest.add(9);   // returns 8
kthLargest.add(4);   // returns 8
 */
public class KthLargest {

    private PriorityQueue<Integer> kLargestMinHeap = new PriorityQueue<>();
    private int k;

    public KthLargest(int k, int[] nums) {
        this.k = k;

        Arrays.sort(nums);
        for (int i=nums.length-1;i>=0 && k>0;--i,--k) kLargestMinHeap.offer(nums[i]);
    }

    public int add(int val) {
        if (k>kLargestMinHeap.size()) kLargestMinHeap.offer(val);
        else if (val>kLargestMinHeap.peek()) {
            kLargestMinHeap.poll();
            kLargestMinHeap.offer(val);
        }

        return kLargestMinHeap.peek();
    }

    public static void main(String[] args) {
        KthLargest k = new KthLargest(7, new int[]{-10,1,3,1,4,10,3,9,4,5,1});
        System.out.println(k.add(3));
        System.out.println(k.add(2));
        System.out.println(k.add(3));
        System.out.println(k.add(1));
//        System.out.println(k.add(4));
    }
}
