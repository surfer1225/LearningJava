package main.java.leetcode.RevisionQns;

import java.util.Arrays;
import java.util.Comparator;

/*
436. Find Right Interval

Given a set of intervals, for each of the interval i,
check if there exists an interval j whose start point is bigger than or equal to the end point of the interval i,
which can be called that j is on the "right" of i.

For any interval i, you need to store the minimum interval j's index,
which means that the interval j has the minimum start point to build the "right" relationship for interval i.
If the interval j doesn't exist, store -1 for the interval i.
Finally, you need output the stored value of each interval as an array.

Note:

You may assume the interval's end point is always bigger than its start point.
You may assume none of these intervals have the same start point.

Example 1:

Input: [ [1,2] ]

Output: [-1]

Explanation: There is only one interval in the collection, so it outputs -1.

Example 2:

Input: [ [3,4], [2,3], [1,2] ]

Output: [-1, 0, 1]

Explanation: There is no satisfied "right" interval for [3,4].
For [2,3], the interval [3,4] has minimum-"right" start point;
For [1,2], the interval [2,3] has minimum-"right" start point.
 */
public class RightInterval {
    public int[] findRightInterval(int[][] intervals) {
        if (intervals == null || intervals.length < 1) return new int[]{};
        int l = intervals.length;
        if (l == 1) return new int[]{-1};

        int[] result = new int[l];

        int[][] backup = new int[l][2];
        for (int i=0;i<l;++i) backup[i] = Arrays.copyOf(intervals[i],2);

        // the right interval value to store the index of the interval
        for (int i=0;i<l;++i) intervals[i][1] = i;

        Arrays.sort(intervals, Comparator.comparingInt(a -> a[0]));

        for (int i=0;i<l;i++) {
            if (backup[i][1]>intervals[l-1][0]) {
                result[i] = -1;
                continue;
            }
            if (backup[i][1]<=intervals[0][0]) {
                result[i] = 0;
                continue;
            }
            result[i] = binarySearch(intervals,0,l-1,backup[i][1]);
        }

        return result;
    }

    private int binarySearch(int[][] intervals, int low, int high, int target) {
        while (low <= high) {
            int mid = (low + high) / 2;
            if (intervals[mid][0] < target) low = mid + 1;
            else {
                if (intervals[mid-1][0] < target) return intervals[mid][1];
                else high = mid - 1;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        RightInterval ri = new RightInterval();
        for (int n:ri.findRightInterval(new int[][]{{3,4},{2,3},{1,2}})) System.out.println(n);
    }
}
