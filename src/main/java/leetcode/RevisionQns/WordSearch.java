package main.java.leetcode.RevisionQns;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by Ryan on 5/5/18.
 */

/*
Given a 2D board and a word, find if the word exists in the grid.

The word can be constructed from letters of sequentially adjacent cell,
where "adjacent" cells are those horizontally or vertically neighboring.
The same letter cell may not be used more than once.

Example:

board =
[
  ['A','B','C','E'],
  ['S','F','C','S'],
  ['A','D','E','E']
]

Given word = "ABCCED", return true.
Given word = "SEE", return true.
Given word = "ABCB", return false.
 */
public class WordSearch {

    public boolean exist(char[][] board, String word) {
        char[] w = word.toCharArray();
        for (int y=0; y<board.length; y++) {
            for (int x=0; x<board[y].length; x++) {
                if (exist(board, y, x, w, 0)) return true;
            }
        }
        return false;
    }

    private boolean exist(char[][] board, int y, int x, char[] word, int i) {
        if (i == word.length) return true;
        if (y<0 || x<0 || y == board.length || x == board[y].length) return false;
        if (board[y][x] != word[i]) return false;
        board[y][x] ^= 256;
        boolean exist = exist(board, y, x+1, word, i+1)
                || exist(board, y, x-1, word, i+1)
                || exist(board, y+1, x, word, i+1)
                || exist(board, y-1, x, word, i+1);
        board[y][x] ^= 256;
        return exist;
    }

    /* time limit exceeded
    public boolean exist(char[][] board, String word) {
        for (int i=0; i<board.length; i++)
            for (int j=0; j<board[0].length; j++) {
                if (DFSTraverse(board,word,0,word.length(), i, j, new HashSet<>())) return true;
            }

        return false;
    }

    private boolean DFSTraverse(char[][] board, String word, int n, int l, int i, int j, Set<Integer> hist) {
        if (n==l) return true;
        for (int m=0;m<n;m++) System.out.print(" ");
        System.out.println(i+","+j+", n is: "+n+", looking for "+word.charAt(n)+", first:"+board[0][0]);
        if (i<0||i>=board.length||j<0||j>=board[0].length||hist.contains(i*10+j)||board[i][j]!=word.charAt(n)) return false;
        hist.add(i*10+j);
        return DFSTraverse(board, word, n+1, l, i, j-1, new HashSet<>(hist)) ||
                DFSTraverse(board, word, n+1, l, i, j+1, new HashSet<>(hist)) ||
                DFSTraverse(board, word, n+1, l, i+1, j, new HashSet<>(hist)) ||
                DFSTraverse(board, word, n+1, l, i-1, j, new HashSet<>(hist));
    }
    */

    public static void main(String[] args) {
        WordSearch w = new WordSearch();
        //char[][] b = new char[][]{{'c','a','a'},{'a','a','a'},{'b','c','d'}};
        //System.out.println(w.exist(b, "aab"));

        char[][] b = new char[][]{{'a','b','c','e'},{'s','f','c','s'},{'a','d','e','e'}};
        System.out.println(w.exist(b, "abcced"));
    }
}
