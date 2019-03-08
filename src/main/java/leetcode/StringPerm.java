package main.java.leetcode;

import java.util.LinkedList;
import java.util.List;

/**
 * Created by Ryan on 10/9/17.
 */
public class StringPerm {
    public static List<String> getStrPerm(String s) { //Can use set to remove duplicate
        if (s.length() == 1) {
            List<String> l = new LinkedList<>();
            l.add(s);
            return l;
        }
        else {
            String firstChar = s.substring(0, 1);
            String remStr = s.substring(1);

            List<String> prevL = getStrPerm(remStr);
            List<String> curL = new LinkedList<>();
            for (String prevLStr: prevL) {
                for (int i=0; i <= prevLStr.length(); i++) {
                    curL.add(insertChar(firstChar, prevLStr, i));
                }
            }
            return curL;
        }
    }

    private static String insertChar(String insertedStr, String baseStr, int insertPox) {
        return baseStr.substring(0, insertPox) + insertedStr + baseStr.substring(insertPox);
    }

    public static void main(String[] args) {
        String str = "abc";
        for (String s: getStrPerm(str)) {
            System.out.println(s);
        }
    }
}
