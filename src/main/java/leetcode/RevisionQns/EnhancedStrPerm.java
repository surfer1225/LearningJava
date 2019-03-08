package main.java.leetcode.RevisionQns;

/**
 * Created by Ryan on 10/9/17.
 */
public class EnhancedStrPerm {

    private static void stringPerm(String beginStr, String endStr) {
        if (endStr.equals("")) {
            System.out.println(beginStr);
        }
        else {
            for (int i=0;i<endStr.length();i++) {
                stringPerm(beginStr + endStr.charAt(i), endStr.substring(0, i) + endStr.substring(i+1));
            }
        }
    }

    public static void main(String[] args) {
        stringPerm("", "abc");
    }
}
