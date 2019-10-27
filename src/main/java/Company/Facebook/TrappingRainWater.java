package main.java.Company.Facebook;

import java.util.HashMap;
import java.util.Map;

/*
42. Trapping Rain Water

Given n non-negative integers representing an elevation map where the width of each bar is 1,
compute how much water it is able to trap after raining.


The above elevation map is represented by array [0,1,0,2,1,0,1,3,2,1,2,1].
In this case, 6 units of rain water (blue section) are being trapped.

Example:

Input: [0,1,0,2,1,0,1,3,2,1,2,1]
Output: 6
 */
public class TrappingRainWater {

    /*
    Approach 1: Brute force
    Intuition

    Do as directed in question. For each element in the array,
    we find the maximum level of water it can trap after the rain,
    which is equal to the minimum of maximum height of bars on both the sides minus its own height.

    Algorithm

    Initialize ans=0ans=0
    Iterate the array from left to right:
    Initialize \text{max\_left}=0max_left=0 and \text{max\_right}=0max_right=0
    Iterate from the current element to the beginning of array updating:
    \text{max\_left}=\max(\text{max\_left},\text{height}[j])max_left=max(max_left,height[j])
    Iterate from the current element to the end of array updating:
    \text{max\_right}=\max(\text{max\_right},\text{height}[j])max_right=max(max_right,height[j])
    Add \min(\text{max\_left},\text{max\_right}) - \text{height}[i]min(max_left,max_right)−height[i] to \text{ans}ans
     */
    public int trap(int[] height) {
        if (height==null || height.length==0) return 0;

        int ans = 0;

        int[] leftMax = new int[height.length], rightMax = new int[height.length];
        leftMax[0] = height[0];
        for (int i=1;i<leftMax.length;++i) leftMax[i]=Math.max(leftMax[i-1],height[i]);

        rightMax[height.length-1] = height[height.length-1];
        for (int i=rightMax.length-2;i>=0;--i) rightMax[i]=Math.max(rightMax[i+1],height[i]);

        for (int i=1;i<height.length-1;++i) {
            ans += Math.min(rightMax[i],leftMax[i]) - height[i];
        }

        return ans;
    }

    /*
    int trap(vector<int>& height)
    {
        int left = 0, right = height.size() - 1;
        int ans = 0;
        int left_max = 0, right_max = 0;
        while (left < right) {
            if (height[left] < height[right]) {
                height[left] >= left_max ? (left_max = height[left]) : ans += (left_max - height[left]);
                ++left;
            }
            else {
                height[right] >= right_max ? (right_max = height[right]) : ans += (right_max - height[right]);
                --right;
            }
        }
        return ans;
    }
     */

    // my solution off taking out unfilled areas from the total area
    /*
    public int trap(int[] height) {
        class LeftRight {
            int left;
            int right;

            public LeftRight(int left, int right) {
                this.left = left;
                this.right = right;
            }
        }

        Map<Integer, LeftRight> heightIndexMap = new HashMap<>();
        int wallArea = 0;
        int maxHeight = 0;

        for (int i=0;i<height.length;++i) {
            wallArea += height[i];
            maxHeight = Math.max(maxHeight, height[i]);

            for (int h=1;h<=height[i];++h) {
                if (heightIndexMap.containsKey(h)) {
                    LeftRight r = heightIndexMap.get(h);
                    r.right = Math.max(r.right, i);
                    r.left = Math.min(r.left, i);
                }
                else {
                    heightIndexMap.put(h,new LeftRight(i,i));
                }
            }
        }

        int unFilledArea = 0;
        for (LeftRight lr:heightIndexMap.values()) {
            unFilledArea += (lr.left + (height.length-lr.right-1));
        }

        return maxHeight * height.length - unFilledArea - wallArea;
    }
    */
}
