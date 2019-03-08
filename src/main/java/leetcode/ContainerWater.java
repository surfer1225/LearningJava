package main.java.leetcode;

/**
 * Created by Ryan on 12/2/18.
 */

/*
Given n non-negative integers a1, a2, ..., an,
where each represents a point at coordinate (i, ai).
n vertical lines are drawn such that the two endpoints of
line i is at (i, ai) and (i, 0). Find two lines,
which together with x-axis forms a container,
such that the container contains the most water.

Note: You may not slant the container and n is at least 2.
 */

public class ContainerWater {
    public int maxArea(int[] height) {
        int maxarea = 0, l = 0, r = height.length - 1;
        while (l < r) {
            maxarea = Math.max(maxarea, Math.min(height[l], height[r]) * (r - l));
            if (height[l] < height[r])
                l++;
            else
                r--;
        }
        return maxarea;
    }
}
