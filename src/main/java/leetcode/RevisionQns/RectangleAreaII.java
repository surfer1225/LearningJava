package main.java.leetcode.RevisionQns;

import java.util.*;

/*
We are given a list of (axis-aligned) rectangles.
Each rectangle[i] = [x1, y1, x2, y2] , where (x1, y1) are the coordinates of the bottom-left corner,
and (x2, y2) are the coordinates of the top-right corner of the ith rectangle.

Find the total area covered by all rectangles in the plane.
Since the answer may be too large, return it modulo 10^9 + 7.
 */
public class RectangleAreaII {
    /*
    Approach #3: Line Sweep
    Intuition

    Imagine we pass a horizontal line from bottom to top over the shape.
    We have some active intervals on this horizontal line, which gets updated twice for each rectangle.
    In total, there are 2 * N2∗N events, and we can update our (up to NN) active horizontal intervals for each update.

    Algorithm

    For a rectangle like rec = [1,0,3,1], the first update is to add [1, 3] to the active set at y = 0,
    and the second update is to remove [1, 3] at y = 1.
    Note that adding and removing respects multiplicity - if we also added [0, 2] at y = 0,
    then removing [1, 3] at y = 1 will still leave us with [0, 2] active.

    This gives us a plan: create these two events for each rectangle, then process all the events in sorted order of y.
    The issue now is deciding how to process the events add(x1, x2) and remove(x1, x2)
    such that we are able to query() the total horizontal length of our active intervals.

    We can use the fact that our remove(...) operation will always be on an interval that was previously added.
    Let's store all the (x1, x2) intervals in sorted order.
    Then, we can query() in linear time using a technique similar to a classic LeetCode problem, Merge Intervals.
     */
    public int rectangleArea(int[][] rectangles) {
        int OPEN = 0, CLOSE = 1;
        int[][] events = new int[rectangles.length * 2][];
        int t = 0;
        for (int[] rec: rectangles) {
            events[t++] = new int[]{rec[1], OPEN, rec[0], rec[2]};
            events[t++] = new int[]{rec[3], CLOSE, rec[0], rec[2]};
        }

        Arrays.sort(events, Comparator.comparingInt(a -> a[0]));

        List<int[]> active = new ArrayList<>();
        int cur_y = events[0][0];
        long ans = 0;
        for (int[] event: events) {
            int y = event[0], typ = event[1], x1 = event[2], x2 = event[3];

            // Calculate query
            long query = 0;
            int cur = -1;
            for (int[] xs: active) {
                cur = Math.max(cur, xs[0]);
                query += Math.max(xs[1] - cur, 0);
                cur = Math.max(cur, xs[1]);
            }

            ans += query * (y - cur_y);

            if (typ == OPEN) {
                active.add(new int[]{x1, x2});
                active.sort(Comparator.comparingInt(a -> a[0]));
            } else {
                for (int i = 0; i < active.size(); ++i)
                    if (active.get(i)[0] == x1 && active.get(i)[1] == x2) {
                        active.remove(i);
                        break;
                    }
            }

            cur_y = y;
        }

        ans %= 1_000_000_007;
        return (int) ans;
    }
}
