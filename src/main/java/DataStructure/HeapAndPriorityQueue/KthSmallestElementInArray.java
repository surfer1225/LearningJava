package main.java.DataStructure.HeapAndPriorityQueue;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * Created by Ryan on 4/1/18.
 */
public class KthSmallestElementInArray {

    public static int find(int [] A, int k){
        PriorityQueue<Integer> pq = new PriorityQueue<>(Comparator.reverseOrder());
//        PriorityQueue<Integer> q = new PriorityQueue<>(Comparator.comparingInt(Integer::intValue));
        for(int i=0;i<A.length;i++){
            pq.offer(A[i]);
        }
        int n = -1;
        while(k>0){
            n = pq.poll();
            k--;
        }
        return n;
    }
    public static void main(String[] args) {
        int[] A = {2, 1};
        //int[] A = { 1, 2, 10, 20, 40, 32, 44, 51, 6 };
        int k = 1;
        System.out.println(""+ k + "th largest element:" + find(A,k));

    }

}
