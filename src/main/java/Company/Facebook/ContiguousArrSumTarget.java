package main.java.Company.Facebook;

import java.util.HashSet;
import java.util.Set;

public class ContiguousArrSumTarget {
    public boolean hasSubsequence(int[] arr, int target) {
        if (arr == null || arr.length==0) return false;

        Set<Integer> sumSet = new HashSet<>();
        sumSet.add(arr[0]);
        for (int i=1;i<arr.length;++i) {
            arr[i]+=arr[i-1];
            if (sumSet.contains(arr[i]-target)) return true;
            sumSet.add(arr[i]);
        }
        return arr[arr.length-1]==target;
    }
}
