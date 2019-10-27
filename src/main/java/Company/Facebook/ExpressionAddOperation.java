package main.java.Company.Facebook;

import java.util.*;
import java.util.stream.Collectors;

/*
282. Expression Add Operators

Given a string that contains only digits 0-9 and a target value,
return all possibilities to add binary operators (not unary) +, -, or *
between the digits so they evaluate to the target value.

Example 1:

Input: num = "123", target = 6
Output: ["1+2+3", "1*2*3"]
Example 2:

Input: num = "232", target = 8
Output: ["2*3+2", "2+3*2"]
Example 3:

Input: num = "105", target = 5
Output: ["1*0+5","10-5"]
Example 4:

Input: num = "00", target = 0
Output: ["0+0", "0-0", "0*0"]
Example 5:

Input: num = "3456237490", target = 9191
Output: []
 */
public class ExpressionAddOperation {
    public List<String> addOperators(String num, int target) {
        if (num == null || num.isEmpty()) return new LinkedList<>();
        if (num.length() == 1) return Integer.parseInt(num) == target ?
                new LinkedList<>(Collections.singleton(num)) : new LinkedList<>();

        List<String> permutations = new LinkedList<>();
        backtrack(num.substring(1), num.substring(0,1), permutations);

        return permutations.stream().filter(s -> isEvalEqualTarget(s, target)).collect(Collectors.toList());
    }

    private boolean isEvalEqualTarget(String formula, int target) {
        Stack<Integer> number = new Stack<>();
        Stack<Character> ops = new Stack<>();

        Set<Character> opsSet = new HashSet<>(Arrays.asList('+','-','*'));

        int i=0, j=0;
        try {
            while (j < formula.length()) {
                char c = formula.charAt(j);

                if (opsSet.contains(c)) {
                    String numberToPush = formula.substring(i, j);
                    if (formula.charAt(i) == '0' && numberToPush.length() > 1) return false;
                    number.push(Integer.parseInt(numberToPush));
                    ops.push(c);
                    j++;
                    i = j;
                } else {
                    j++;
                }
            }
            String numberToPush = formula.substring(i, j);
            if (formula.charAt(i) == '0' && numberToPush.length() > 1) return false;
            number.push(Integer.parseInt(numberToPush));
        } catch (NumberFormatException e) {
            return false;
        }

        Stack<Integer> numberWithoutMultiplication = new Stack<>();
        Stack<Character> opsWithoutMultiplication = new Stack<>();

        int prev = number.pop();

        while (!number.isEmpty()) {
            char op = ops.pop();
            int cur = number.pop();

            if (op == '*') prev *= cur;
            else {
                numberWithoutMultiplication.push(prev);
                prev = cur;
                opsWithoutMultiplication.push(op);
            }
        }

        while (!numberWithoutMultiplication.isEmpty()) {
            char op = opsWithoutMultiplication.pop();
            int cur = numberWithoutMultiplication.pop();

            prev = op == '+' ? prev + cur : prev - cur;
        }

        //System.out.println(formula + "=" +prev);

        return prev == target;
    }

    private void backtrack(String num, String acc, List<String> permutations) {
        if (num.length() == 1) {
            permutations.add(acc.concat("+").concat(num));
            permutations.add(acc.concat("-").concat(num));
            permutations.add(acc.concat("*").concat(num));
            permutations.add(acc.concat(num));
        }
        else {
            String next = num.substring(1);
            String curChar = num.substring(0,1);
            backtrack(next, acc+"+"+curChar, permutations);
            backtrack(next, acc+"-"+curChar, permutations);
            backtrack(next, acc+"*"+curChar, permutations);
            backtrack(next, acc+curChar, permutations);
        }
    }

    public static void main(String[] args) {
        ExpressionAddOperation eao = new ExpressionAddOperation();
        for (String str:eao.addOperators("123", 6))
            System.out.println(str);

        for (String str:eao.addOperators("3456237490", 9191))
            System.out.println(str);
    }
}
