package main.java.DataStructure.Array;

/**
 * Created by Ryan on 11/2/18.
 */

/*
Given a 2D binary matrix filled with 0's and 1's,
find the largest square containing only 1's and return its area.

For example, given the following matrix:

1 0 1 0 0
1 0 1 1 1
1 1 1 1 1
1 0 0 1 0
Return 4.
 */

public class MaximalSquare {
    public int maximalSquare(char[][] matrix) {
        int l = matrix.length;
        if (l==0) return 0;
        int w = matrix[0].length;
        int[][] sqr = new int[l][w];

        int max = 0;
        for (int i=0;i<l;i++) {
            sqr[i][0]=Character.getNumericValue(matrix[i][0]);
            max = Math.max(max, sqr[i][0]);
        }
        for (int i=1;i<w;i++) {
            sqr[0][i]=Character.getNumericValue(matrix[0][i]);
            max = Math.max(max, sqr[0][i]);
        }

        for (int i=1;i<l;i++) {
            for (int j=1;j<w;j++) {
                sqr[i][j]=matrix[i][j]=='0'?0:Math.min(sqr[i][j-1], Math.min(sqr[i-1][j], sqr[i-1][j-1]))+1;
                max = Math.max(max, sqr[i][j]);
            }
        }

        return max * max;
    }
}
