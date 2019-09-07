package main.java.leetcode.RevisionQns;

import java.util.Arrays;

/*
Find the kth largest element in an unsorted array.
Note that it is the kth largest element in the sorted order, not the kth distinct element.

Example 1:

Input: [3,2,1,5,6,4] and k = 2
Output: 5
 */
public class KthLargestInArr {
    private int[] heap;
    private int capacity;

    public int findKthLargest(int[] nums, int k) {
        heap = new int[k];
        capacity = k;
        Arrays.fill(heap, Integer.MIN_VALUE);
        for (int n : nums) {
            insert(n);
        }
//        for (int n : heap) System.out.println(n);
        return heap[0];
    }

    private void insert(int x) {
        if (x > heap[0]) {
            heap[0] = x;
            heapify();
        }
    }

    private void heapify() {
        int i = 0, child;
        int temp = heap[0];
        while (2 * i + 1 < capacity) {
            child = minChild(i);
            if (temp > heap[child]) {
                heap[i] = heap[child];
                heap[child] = temp;
                i = child;
            } else break;
        }
    }

    private int minChild(int i) {
        int left = 2 * i + 1;
        int right = 2 * i + 2;
        return right >= capacity || heap[left] < heap[right] ? left : right;
    }

    public static void main(String[] args) {
        KthLargestInArr k = new KthLargestInArr();
        k.findKthLargest(new int[]{3,2,3,1,2,4,5,5,6},4);
    }
}
