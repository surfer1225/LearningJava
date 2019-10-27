package main.java.Company.Facebook;

import java.util.Comparator;
import java.util.PriorityQueue;

/*
973. K Closest Points to Origin

We have a list of points on the plane.  Find the K closest points to the origin (0, 0).
(Here, the distance between two points on a plane is the Euclidean distance.)
You may return the answer in any order.  The answer is guaranteed to be unique (except for the order that it is in.)

Example 1:
Input: points = [[1,3],[-2,2]], K = 1
Output: [[-2,2]]
Explanation:
The distance between (1, 3) and the origin is sqrt(10).
The distance between (-2, 2) and the origin is sqrt(8).
Since sqrt(8) < sqrt(10), (-2, 2) is closer to the origin.
We only want the closest K = 1 points from the origin, so the answer is just [[-2,2]].
Example 2:
Input: points = [[3,3],[5,-1],[-2,4]], K = 2
Output: [[3,3],[-2,4]]
(The answer [[-2,4],[3,3]] would also be accepted.)
 */
public class KClosestPointsToOrigin {
    public int[][] kClosest(int[][] points, int K) {
        PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingDouble(pt -> -getDistance(pt)));
        for (int[] pt:points) {
            if (pq.size() < K) pq.offer(pt);
            else {
                if (getDistance(pq.peek()) > getDistance(pt)) {
                    pq.poll();
                    pq.offer(pt);
                }
            }
        }
        return pq.toArray(new int[0][]);
    }

    private double getDistance(int[] pt) {
        return Math.sqrt(pt[0]*pt[0] + pt[1]*pt[1]);
    }
}
