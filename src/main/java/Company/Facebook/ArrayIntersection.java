package main.java.Company.Facebook;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ArrayIntersection {
    public int[] intersection(int[] nums1, int[] nums2) {
        Arrays.sort(nums1);
        Arrays.sort(nums2);

        List<Integer> result = new ArrayList<>();

        int left1 = 0, left2 = 0;

        while (left1<nums1.length && left2<nums2.length) {
            int n1 = nums1[left1], n2 = nums2[left2];
            if (n1 == n2) {
                result.add(n1);
                while (n1 == nums1[left1]) left1++;
                while (n2 == nums2[left2]) left2++;
                continue;
            }
            if (n2 > n1) while (n1 == nums1[left1]) left1++;
            else while (n2 == nums2[left2]) left2++;
        }

        return result.stream().mapToInt(Integer::intValue).toArray();
    }
}
