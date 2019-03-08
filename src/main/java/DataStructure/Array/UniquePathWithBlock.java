package main.java.DataStructure.Array;

/**
 * Created by Ryan on 15/1/18.
 */

/*
Follow up for "Unique Paths": From upper left to lower right

Now consider if some obstacles are added to the grids. How many unique paths would there be?

An obstacle and empty space is marked as 1 and 0 respectively in the grid.

For example,
There is one obstacle in the middle of a 3x3 grid as illustrated below.

[
  [0,0,0],
  [0,1,0],
  [0,0,0]
]
The total number of unique paths is 2.
 */
public class UniquePathWithBlock {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int l=obstacleGrid.length, w=obstacleGrid[0].length;
        if (obstacleGrid[l-1][w-1]==1) return 0;
        obstacleGrid[0][0]=1-obstacleGrid[0][0];
        for (int i=1;i<l;i++) obstacleGrid[i][0]=obstacleGrid[i][0]==1?0:obstacleGrid[i-1][0];
        for (int i=1;i<w;i++) obstacleGrid[0][i]=obstacleGrid[0][i]==1?0:obstacleGrid[0][i-1];
        for (int i=1;i<l;i++) {
            for (int j=1;j<w;j++) {
                obstacleGrid[i][j]=obstacleGrid[i][j]==1?0:obstacleGrid[i-1][j]+obstacleGrid[i][j-1];
            }
        }
        return obstacleGrid[l-1][w-1];
    }

    public static void main(String[] args) {
        UniquePathWithBlock u = new UniquePathWithBlock();
        System.out.println(u.uniquePathsWithObstacles(new int[][]{{0,0},{1,1},{0,0}}));
    }
}
