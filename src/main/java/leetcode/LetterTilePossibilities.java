package main.java.leetcode;

import java.util.HashSet;
import java.util.Set;

/*
Example 1:

Input: "AAB"
Output: 8
Explanation: The possible sequences are "A", "B", "AA", "AB", "BA", "AAB", "ABA", "BAA".
 */
public class LetterTilePossibilities {
    public int numTilePossibilities(String tiles) {
        Set<String> possibilities = new HashSet<>();

        permute(tiles,possibilities,"");

        return possibilities.size();
    }

    private void permute(String tiles, Set<String> possibilities, String acc) {
        if (!acc.isEmpty()) possibilities.add(acc);
        for (int i=0;i<tiles.length();i++) {
            permute(tiles.substring(0,i)+tiles.substring(i+1),possibilities,acc+tiles.charAt(i));
        }
    }

    public static void main(String[] args) {
        LetterTilePossibilities l = new LetterTilePossibilities();
        System.out.println(l.numTilePossibilities("AAB"));
    }
}
