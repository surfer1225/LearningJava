package main.java.leetcode;

/**
 * Created by Ryan on 2/9/17.
 * There are two sorted arrays nums1 and nums2 of size m and n respectively.
 * Find the median of the two sorted arrays. The overall run time complexity should be O(log (m+n)).
 */
public class MedianSortedArr {
    public static double findMedianSortedArrays(int[] A, int[] B) {

        int m = A.length;
        int n = B.length;
        if (m > n) { // to ensure m<=n
            int[] temp = A; A = B; B = temp;
            int tmp = m; m = n; n = tmp;
        }
        int iMin = 0, iMax = m, halfLen = (m + n + 1) / 2;
        while (iMin <= iMax) {
            int i = (iMin + iMax) / 2;
            int j = halfLen - i;
            if (i < iMax && B[j-1] > A[i]){
                iMin = i + 1; // i is too small
            }
            else if (i > iMin && A[i-1] > B[j]) {
                iMax = i - 1; // i is too big
            }
            else { // i is perfect
                int maxLeft = 0;
                if (i == 0) { maxLeft = B[j-1]; }
                else if (j == 0) { maxLeft = A[i-1]; }
                else { maxLeft = Math.max(A[i-1], B[j-1]); }
                if ( (m + n) % 2 == 1 ) { return maxLeft; }

                int minRight = 0;
                if (i == m) { minRight = B[j]; }
                else if (j == n) { minRight = A[i]; }
                else { minRight = Math.min(B[j], A[i]); }

                return (maxLeft + minRight) / 2.0;
            }
        }
        return 0.0;
    }

    public static void main(String[] args) {


//        int[] arr5 = {1, 2};
//        int[] arr6 = {-1, 4};
//        System.out.println(findMedianSortedArrays(arr5, arr6));
//
//        int[] arr1 = {1, 2};
//        int[] arr2 = {3, 4};
//        System.out.println(findMedianSortedArrays(arr1, arr2));

        int[] arr3 = {3,5};
        int[] arr4 = {2};
        System.out.println(findMedianSortedArrays(arr4, arr3));
    }
}

/*
https://leetcode.com/problems/median-of-two-sorted-arrays/solution/
 */