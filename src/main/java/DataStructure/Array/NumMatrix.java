package main.java.DataStructure.Array;

/*
304. Range Sum Query 2D - Immutable

Given a 2D matrix matrix,
find the sum of the elements inside the rectangle
defined by its upper left corner (row1, col1) and lower right corner (row2, col2).

Given matrix = [
  [3, 0, 1, 4, 2],
  [5, 6, 3, 2, 1],
  [1, 2, 0, 1, 5],
  [4, 1, 0, 1, 7],
  [1, 0, 3, 0, 5]
]

sumRegion(2, 1, 4, 3) -> 8
sumRegion(1, 1, 2, 2) -> 11
sumRegion(1, 2, 2, 4) -> 12
 */
class NumMatrix {

    int[][] sum;

    public NumMatrix(int[][] matrix) {
        if (matrix!=null && matrix.length>0) {
            sum = new int[matrix.length][matrix[0].length];
            for (int i=0;i<matrix.length;i++) {
                for (int j=0;j<matrix[0].length;j++) {
                    if (j==0) sum[i][j] = matrix[i][j];
                    else sum[i][j] = matrix[i][j] + sum[i][j-1];
                }
            }

            for (int i=1;i<matrix.length;i++) {
                for (int j=0;j<matrix[0].length;j++) {
                    sum[i][j] += sum[i-1][j];
                }
            }
        }
    }

    public int sumRegion(int row1, int col1, int row2, int col2) {
        return sum[row2][col2] - (col1==0?0:sum[row2][col1-1]) - (row1==0?0:sum[row1-1][col2])
                + (col1==0||row1==0?0:sum[row1-1][col1-1]);
    }
}
