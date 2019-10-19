package main.java.Company.Facebook;

/*
Generate random max index

Given an array of integers, randomly return an index of the maximum value seen by far.

e.g.
Given [11,30,2,30,30,30,6,2,62, 62]

Having iterated up to the at element index 5 (where the last 30 is),
randomly give an index among [1, 3, 4, 5] which are indices of 30 - the max value by far.
Each index should have a ¼ chance to get picked.

Having iterated through the entire array, randomly give an index between 8 and 9 which are indices of the max value 62.
 */

import java.util.ArrayList;
import java.util.List;

public class MaxRandom {
    public int getMaxRandom(int[] arr) {
        int idx = (int) Math.random() * arr.length;

        int max = Integer.MIN_VALUE;
        List<Integer> indices = new ArrayList<>();

        for (int i=0;i<=idx;++i) {
            if (max < arr[i]) {
                max = arr[i];
                indices = new ArrayList<>();
                indices.add(i);
            }
            else if (max == arr[i]) {
                indices.add(i);
            }
        }

        return indices.get((int) (Math.random() * indices.size()));
    }
}
