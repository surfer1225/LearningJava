package main.java.leetcode.RevisionQns;

public class InterleavingString {
    public static void main(String[] args) {
        InterleavingString is = new InterleavingString();
        System.out.println(is.isInterleave("aabd", "abdc", "aabdbadc"));
        System.out.println(is.isInterleave("aabcc", "dbbca", "aadbbcbcac"));
    }

    public boolean isInterleave(String s1, String s2, String s3) {
        int l1 = s1.length(), l2 = s2.length();
        if (l1 + l2 != s3.length()) return false;
        boolean res[][] = new boolean[l1 + 1][l2 + 1];
        res[0][0] = true;

        for (int i = 0; i < s1.length(); ++i) {
            res[i + 1][0] = s1.charAt(i) == s3.charAt(i) && res[i][0];
        }
        for (int i = 0; i < s2.length(); ++i) {
            res[0][i + 1] = s2.charAt(i) == s3.charAt(i) && res[0][i];
        }
        for (int i = 1; i <= s1.length(); ++i) {
            for (int j = 1; j <= s2.length(); ++j) {
                res[i][j] = (s1.charAt(i - 1) == s3.charAt(i + j - 1) && res[i - 1][j]) ||
                        (s2.charAt(j - 1) == s3.charAt(i + j - 1) && res[i][j - 1]);
            }
        }

        return res[s1.length()][s2.length()];
    }
}
