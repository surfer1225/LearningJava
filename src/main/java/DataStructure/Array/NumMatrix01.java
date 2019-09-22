package main.java.DataStructure.Array;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

/*
542. 01 Matrix

Given a matrix consists of 0 and 1, find the distance of the nearest 0 for each cell.

The distance between two adjacent cells is 1.

Example 1:

Input:
[[0,0,0],
 [0,1,0],
 [0,0,0]]

Output:
[[0,0,0],
 [0,1,0],
 [0,0,0]]
Example 2:

Input:
[[0,0,0],
 [0,1,0],
 [1,1,1]]

Output:
[[0,0,0],
 [0,1,0],
 [1,2,1]]
 */
public class NumMatrix01 {

    public int[][] updateMatrix(int[][] matrix) {
        int row = matrix.length, col = matrix[0].length;

        Queue<Integer> q = new LinkedList<>();
        Map<Integer, Integer> depth = new HashMap<>();

        for (int i=0;i<row;++i) {
            for (int j=0;j<col;++j) {
                int code = getPositionCode(i,j,col);
                if (matrix[i][j]==0) {
                    q.add(code);
                    depth.put(code, 0);
                }
            }
        }

        int[] rowDir = new int[]{-1,0,1,0};
        int[] colDir = new int[]{0,-1,0,1};

        while (!q.isEmpty()) {
            int position = q.poll();

            int curR = position / col;
            int curC = position % col;

            for (int i=0;i<4;++i) {
                for (int j=0;j<4;++j) {
                    int newR = curR + rowDir[i];
                    int newC = curC + colDir[i];

                    int newPosition = getPositionCode(newR,newC,col);

                    if (newC>=0 && newR>=0 && newR<row && newC<col && matrix[newR][newC]==1 && !depth.containsKey(newPosition)) {
                        matrix[newR][newC] = depth.get(getPositionCode(curR,curC,col))+1;
                        depth.put(newPosition,matrix[newR][newC]);
                        q.add(newPosition);
                    }
                }
            }
        }

        return matrix;
    }

    private int getPositionCode(int r, int c, int col) {
        return r * col + c;
    }

    public static void main(String[] args) {
        NumMatrix01 n = new NumMatrix01();
        int[][] matrix = n.updateMatrix(new int[][]{{0,0,0},{0,1,0},{1,1,1}});
        for (int i=0;i<matrix.length;++i) {
            for (int j=0;j<matrix[0].length;++j) {
                System.out.print(matrix[i][j] + ", ");
            }
            System.out.println();
        }
    }
}
