package main.java.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Ryan on 22/2/18.
 */

/*
Given a 2d grid map of '1's (land) and '0's (water), count the number of islands.
An island is surrounded by water and is formed by connecting adjacent lands horizontally or vertically.
You may assume all four edges of the grid are all surrounded by water.

Example 1:

11110
11010
11000
00000
Answer: 1

Example 2:

11000
11000
00100
00011
Answer: 3
 */
public class NumberOfIslands {
    public int numIslands(char[][] grid) {
        int cnt = 0;
        int n = grid.length;
        if (n == 0) return 0;
        int m = grid[0].length;
        for (int i = 0; i < n; i++){
            for (int j = 0; j < m; j++)
                if (grid[i][j] == '1') {
                    DFSTraversal(grid, i, j, n, m);
                    cnt++;
                }
        }
        return cnt;
    }

    private void DFSTraversal(char[][] grid, int i, int j, int n, int m) {
        if (i < 0 || j < 0 || i >= n || j >= m || grid[i][j] != '1') return;
        grid[i][j] = '0';
        DFSTraversal(grid, i + 1, j, n, m);
        DFSTraversal(grid, i - 1, j, n, m);
        DFSTraversal(grid, i, j + 1, n, m);
        DFSTraversal(grid, i, j - 1, n, m);
    }
}
