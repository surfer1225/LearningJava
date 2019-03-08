package main.java.DataStructure.Array;

/**
 * Created by Ryan on 5/5/18.
 */
public class ArrayCopy {
    public static void main(String[] args) {
        int[][] a = new int[][] {{1, 2, 3, 4},{1, 2, 3, 4}};
        int[][] b = a.clone();
        b[1][1]+=2;

        for (int i:a[1]) {
            System.out.println(i);
        }
        System.out.println();
        for (int i:b[1]) {
            System.out.println(i);
        }
    }
}
