package main.java.Company.Amazon;

// IMPORT LIBRARY PACKAGES NEEDED BY YOUR PROGRAM
// SOME CLASSES WITHIN A PACKAGE MAY BE RESTRICTED
// DEFINE ANY CLASS AND METHOD NEEDED
import java.util.List;
import java.util.ArrayList;
// CLASS BEGINS, THIS CLASS IS REQUIRED
public class Solution
{
    int min = Integer.MAX_VALUE;
    // METHOD SIGNATURE BEGINS, THIS METHOD IS REQUIRED
    int removeObstacle(int numRows, int numColumns, List<List<Integer>> lot)
    {
        // WRITE YOUR CODE HERE
        int m = lot.size();
        int n = lot.get(0).size();
        DFSTraverse(new ArrayList<>(lot), 0, 0, m, n, 0);
        return min == Integer.MAX_VALUE?-1:min;
    }
    // METHOD SIGNATURE ENDS

    private void DFSTraverse(List<List<Integer>> lot, int i, int j, int m, int n, int steps) {
        if (i<0 || j<0 || i>=m || j>=n || lot.get(i).get(j)==0) return;
        if (lot.get(i).get(j)==9) {
            min = Math.min(steps, min);
            return;
        }
        lot.get(i).set(j, 0);
        DFSTraverse(new ArrayList<>(lot), i+1, j, m, n, steps+1);
        DFSTraverse(new ArrayList<>(lot), i-1, j, m, n, steps+1);
        DFSTraverse(new ArrayList<>(lot), i, j+1, m, n, steps+1);
        DFSTraverse(new ArrayList<>(lot), i, j-1, m, n, steps+1);
    }
}