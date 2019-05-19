package main.java.leetcode.RevisionQns;

import java.util.HashSet;
import java.util.Set;

/*
Determine if a 9x9 Sudoku board is valid. Only the filled cells need to be validated according to the following rules:

Each row must contain the digits 1-9 without repetition.
Each column must contain the digits 1-9 without repetition.
Each of the 9 3x3 sub-boxes of the grid must contain the digits 1-9 without repetition.

The Sudoku board could be partially filled, where empty cells are filled with the character '.'.

Example 1:

Input:
[
  ["5","3",".",".","7",".",".",".","."],
  ["6",".",".","1","9","5",".",".","."],
  [".","9","8",".",".",".",".","6","."],
  ["8",".",".",".","6",".",".",".","3"],
  ["4",".",".","8",".","3",".",".","1"],
  ["7",".",".",".","2",".",".",".","6"],
  [".","6",".",".",".",".","2","8","."],
  [".",".",".","4","1","9",".",".","5"],
  [".",".",".",".","8",".",".","7","9"]
]
Output: true
 */
public class ValidSudoku {
    public boolean isValidSudoku(char[][] board) {
        boolean vertical = verticalCheck(board);
        boolean horizontal = horizontalCheck(board);
        boolean boardUnit = boardCheck(board);
        return vertical && horizontal && boardUnit;
    }

    private boolean verticalCheck(char[][] board) {
        for (int i=0;i<9;++i) {
            Set<Character> s = new HashSet<>();
            for (int j=0;j<9;++j) {
                if (board[j][i]=='.') continue;
                if (s.contains(board[j][i])) return false;
                else s.add(board[j][i]);
            }
        }
        return true;
    }

    private boolean horizontalCheck(char[][] board) {
        for (int i=0;i<9;++i) {
            Set<Character> s = new HashSet<>();
            for (int j=0;j<9;++j) {
                if (board[i][j]=='.') continue;
                if (s.contains(board[i][j])) return false;
                else s.add(board[i][j]);
            }
        }
        return true;
    }

    private boolean boardCheck(char[][] board) {
        for (int i=0;i<9;i+=3) {
            for (int j=0;j<9;j+=3) {
                Set<Character> s = new HashSet<>();
                for (int x=i;x<i+3;++x) {
                    for (int y=j;y<j+3;++y) {
                        if (board[x][y]=='.') continue;
                        if (s.contains(board[x][y])) return false;
                        else s.add(board[x][y]);
                    }
                }
            }
        }
        return true;
    }
}
