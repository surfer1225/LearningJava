package main.java.DataStructure.Array;

/*
498. Diagonal Traverse

Given a matrix of M x N elements (M rows, N columns),
return all elements of the matrix in diagonal order as shown in the below image.

Example:

Input:
[
 [ 1, 2, 3 ],
 [ 4, 5, 6 ],
 [ 7, 8, 9 ]
]

Output:  [1,2,4,7,5,3,6,8,9]
 */
public class DiagonalTraversal {
    public int[] findDiagonalOrder(int[][] matrix) {

        if (matrix == null || matrix.length == 0) return new int[]{};

        int l = matrix.length, w = matrix[0].length;
        int[] diagonal = new int[l*w];

        boolean up = true;

        /*
        0,0 -> 0,1 -> 1,0 -> 2,0 -> 1,1 -> 0,2 -> 2,1 -> 1,2 -> 2,2
        0,0 -> 0,1 -> 1,0 -> 2,0 -> 1,1 -> 0,2 -> 0,3 -> 1,2 -> 2,1 -> 3,0 ->
        0,0 -> 0,1 -> 1,0 -> 1,1 -> 0,2 -> 1,2
        */
        int max = (l-1) + (w-1);
        int cnt = 0;
        for (int i=0;i<=max;i++) {
            if (up) {
                for (int j=Math.max(0,i-l+1);j<=i && j<w;j++) {
                    diagonal[cnt++]=matrix[i-j][j];
                }
            }
            else {
                for (int j=Math.max(0,i-w+1);j<=i && j<l;j++) {
                    diagonal[cnt++]=matrix[j][i-j];
                }
            }
            up = !up;
        }

        return diagonal;
    }
}
