package main.java.DataStructure.Array;

/*
Given an array, all numbers appear twice except one
*/
public class FindOnlyNonRepeatedNumber {
    public static int findNum(int[] arr) {
        int res = arr[0];
        for (int i=1;i<arr.length;i++) {
            res ^= arr[i];
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(findNum(new int[]{2,2,4,4,3,5,5}));
    }
}
