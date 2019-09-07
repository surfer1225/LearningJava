package main.java.leetcode.RevisionQns;

import java.util.*;

public class WordSearchII {
    public List<String> findWords(char[][] board, String[] words) {
        List<String> res = new LinkedList<>();
        for (String word:words) {
            if (findWord(board,word)) res.add(word);
        }
        return res;
    }

    private boolean findWord(char[][] board, String word) {
        int pos = 0;
        for (int i=0;i<board.length;++i) {
            for (int j=0;j<board[0].length;++j) {
                if (board[i][j]==word.charAt(pos)) {
                    boolean[][] visited = new boolean[board.length][board[0].length];
                    if (dfs(board, word, visited, pos, i, j)) return true;
                }
            }
        }
        return false;
    }

    private boolean dfs(char[][] board, String word, boolean[][] visited, int pos, int i, int j) {
        if (pos == word.length()) return true;
        if (i<0 || i>=board.length || j<0 || j>=board[0].length || word.charAt(pos)!=board[i][j] || visited[i][j]) return false;

        visited[i][j]=true;

        if (dfs(board,word,visited,pos+1,i,j+1)) return true;
        if (dfs(board,word,visited,pos+1,i,j-1)) return true;
        if (dfs(board,word,visited,pos+1,i+1,j)) return true;
        if (dfs(board,word,visited,pos+1,i-1,j)) return true;

        visited[i][j]=false;
        return false;
    }
}
