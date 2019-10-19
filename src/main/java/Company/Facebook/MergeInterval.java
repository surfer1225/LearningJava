package main.java.Company.Facebook;

import java.util.*;

/*
56. Merge Intervals

Given a collection of intervals, merge all overlapping intervals.

Example 1:

Input: [[1,3],[2,6],[8,10],[15,18]]
Output: [[1,6],[8,10],[15,18]]
Explanation: Since intervals [1,3] and [2,6] overlaps, merge them into [1,6].
Example 2:

Input: [[1,4],[4,5]]
Output: [[1,5]]
Explanation: Intervals [1,4] and [4,5] are considered overlapping.
 */

public class MergeInterval {
    class Interval {
        int start;
        int end;
        Interval() { start = 0; end = 0; }
        Interval(int s, int e) { start = s; end = e; }
    }

    public int[][] merge(int[][] intervals) {
        if (intervals == null || intervals.length==0) return intervals;
        Arrays.sort(intervals, Comparator.comparingInt(interval -> interval[0]));

        Interval cur = null;
        List<Interval> result = new LinkedList<>();

        for (int[] interval:intervals) {
            if (cur == null) cur = new Interval(interval[0], interval[1]);
            else if (cur.end >= interval[0]) cur = new Interval(cur.start, Math.max(cur.end, interval[1]));
            else {
                result.add(cur);
                cur = new Interval(interval[0],interval[1]);
            }
        }

        result.add(cur);

        return result.stream().map(i -> new int[]{i.start,i.end}).toArray(int[][]::new);
    }
}
