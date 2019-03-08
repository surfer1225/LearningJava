package main.java.leetcode;

import java.util.Stack;

/**
 * Created by Ryan on 13/12/17.
 */

/*
Given a string containing just the characters '(', ')', '{', '}', '[' and ']', determine if the input string is valid.

The brackets must close in the correct order, "()" and "()[]{}" are all valid but "(]" and "([)]" are not.
 */
public class ValidBrackets {

    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        for (int i=0;i<s.length();i++) {
            Character c = s.charAt(i);
            switch (c) {
                case '(':
                case '[':
                case '{':
                    stack.push(c);
                    break;
                case ')':
                    if (stack.isEmpty() || !stack.pop().equals('(')) return false;
                    break;
                case ']':
                    if (stack.isEmpty() || !stack.pop().equals('[')) return false;
                    break;
                case '}':
                    if (stack.isEmpty() || !stack.pop().equals('{')) return false;
                    break;
            }
        }
        if (stack.isEmpty()) return true;
        return false;
    }

    public static void main(String[] args) {
        ValidBrackets vb = new ValidBrackets();
        System.out.println(vb.isValid("()"));
    }
}
