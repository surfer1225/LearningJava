package main.java.leetcode;

import java.util.*;

/**
 * Created by Ryan on 10/9/17.
 */
public class ParenthesesGen {

    private Set<String> set = new HashSet<>();

    public List<String> generateParenthesis(int n) {
        String parens = "";
        for (int i=0;i<n;i++) {
            parens = parens.concat("(");
        }
        for (int i=0;i<n;i++) {
            parens = parens.concat(")");
        }
        System.out.println("paren: " + parens + "   n: " + n);
        Set<String> resultSet = permuteStr("", parens);
        return new ArrayList<>(resultSet);
    }

    private Set<String> permuteStr(String beginStr, String endStr) {
        if (endStr.equals("")) {
            set.add(beginStr);
            return set;
        }
        else {
            for (int i=0;i<endStr.length();i++) {
                set.addAll(permuteStr(beginStr+endStr.charAt(i), endStr.substring(0,i)+endStr.substring(i+1)));
            }
            return set;
        }
    }

    public static void main(String[] args) {
        for (String s: new ParenthesesGen().generateParenthesis(3)) {
            System.out.println("string" + s);
        }
    }
}
