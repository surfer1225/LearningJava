package main.java.leetcode;

/**
 * Created by Ryan on 23/3/18.
 */

/*
You are given a map in form of a two-dimensional integer grid
where 1 represents land and 0 represents water.
Grid cells are connected horizontally/vertically (not diagonally).
The grid is completely surrounded by water, and there is exactly one island
(i.e., one or more connected land cells). The island doesn't have "lakes"
(water inside that isn't connected to the water around the island).
One cell is a square with side length 1. The grid is rectangular,
width and height don't exceed 100. Determine the perimeter of the island.
 */

public class IslandPerimeter {
    int num=0;
    public int islandPerimeter(int[][] grid) {
        int l = grid.length;
        int w = grid[0].length;

        for (int i=0;i<l;i++)
            for (int j=0;j<w;j++)
                if (grid[i][j]==1) return dfsPerimeter(i,j,grid,0)-num;
        return 0;
    }

    private int dfsPerimeter(int l, int w, int[][] grid, int perim) {
        if (l<0||w<0||l>grid.length||w>grid[0].length||grid[l][w]==0) return 0;
        num++;
        grid[l][w]=0;
        int left,right,up,down;
        left=dfsPerimeter(l,w-1,grid,perim);
        perim+=(left==0?1:left);
        right=dfsPerimeter(l,w+1,grid,perim);
        perim+=(right==0?1:right);
        up=dfsPerimeter(l-1,w,grid,perim);
        perim+=(up==0?1:up);
        down=dfsPerimeter(l+1,w,grid,perim);
        return perim+(down==0?1:down);
    }
}
