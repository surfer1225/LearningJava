package main.java.leetcode.RevisionQns;

/*
Set Matrix Zeros

Given a m x n matrix, if an element is 0, set its entire row and column to 0. Do it in-place.

Example 1:

Input:
[
  [1,1,1],
  [1,0,1],
  [1,1,1]
]
Output:
[
  [1,0,1],
  [0,0,0],
  [1,0,1]
]
 */
public class SetMatrixZero {
    public void setZeroes(int[][] matrix) {
        int m = matrix.length, n = matrix[0].length;
        boolean rowZero = matrix[0][0]==0, columnZero = matrix[0][0]==0;

        for (int i=1;i<n;i++) rowZero = rowZero || matrix[0][i]==0;
        for (int i=1;i<m;i++) columnZero = columnZero || matrix[i][0]==0;

        for (int i=1;i<m;i++) {
            for (int j=1;j<n;j++) {
                if (matrix[i][j]==0) {
                    matrix[i][0]=0;
                    matrix[0][j]=0;
                }
            }
        }

        for (int i=1;i<m;i++)
            if (matrix[i][0]==0)
                for (int j = 1; j < n; j++) matrix[i][j] = 0;

        for (int i=1;i<n;i++)
            if (matrix[0][i]==0)
                for (int j = 1; j < m; j++) matrix[j][i] = 0;

        if (columnZero) for (int i = 0; i < m; i++) matrix[i][0] = 0;
        if (rowZero) for (int i = 0; i < n; i++) matrix[0][i] = 0;
    }
}
