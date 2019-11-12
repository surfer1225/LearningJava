package main.java.Company.Facebook;

import java.util.*;

/*
301. Remove Invalid Parentheses

Remove the minimum number of invalid parentheses in order to make the input string valid. Return all possible results.

Note: The input string may contain letters other than the parentheses ( and ).

Example 1:

Input: "()())()"
Output: ["()()()", "(())()"]
Example 2:

Input: "(a)())()"
Output: ["(a)()()", "(a())()"]
Example 3:

Input: ")("
Output: [""]
 */
public class RemoveInvalidParen {
    public List<String> removeInvalidParentheses(String s) {
        List<String> combinations = new LinkedList<>();
        backtrack("",s,combinations);

        Set<String> res = new HashSet<>();
        int max = 0;
        for (String str:combinations) {
            if (isValidExpression(str)) {
                if (str.length() > max) {
                    res = new HashSet<>();
                    res.add(str);
                    max = str.length();
                }
                else if (str.length() == max) {
                    res.add(str);
                }
            }
        }

        return new LinkedList<>(res);
    }

    private void backtrack(String acc, String rem, List<String> combinations) {
        if (rem.isEmpty()) {
            combinations.add(acc);
        }
        else {
            char c = rem.charAt(0);
            if (c == '(' || c == ')') {
                backtrack(acc + c, rem.substring(1), combinations);
                backtrack(acc, rem.substring(1), combinations);
            }
            else {
                backtrack(acc + c, rem.substring(1), combinations);
            }
        }
    }

    private boolean isValidExpression(String s) {
        Stack<Character> st = new Stack<>();
        for (int i=0;i<s.length();++i) {
            char c = s.charAt(i);
            if (c=='(') st.push(c);
            else if (c==')') {
                if (st.isEmpty()) return false;
                else st.pop();
            }
        }
        return st.isEmpty();
    }

    public static void main(String[] args) {
        RemoveInvalidParen r = new RemoveInvalidParen();
        for (String str:r.removeInvalidParentheses("(a)())()")) {
            System.out.println(str);
        }
    }
}
/*
Approach 2: Limited Backtracking!
Although the previous solution does get accepted on the platform, it is a very inefficient solution because we try removing each and every possible parentheses from the expression and in the end we check two things:

if the expression is valid or not
if the total number of removed parentheses removed in the current recursion is less than the global minimum till now or not.
We cannot determine which of the parentheses are misplaced because, as the problem statement puts across, we can remove multiple combinations of parentheses and end up with a valid expression. This means there can be multiple valid expressions from a single invalid expression and we have to find all of them.

The one thing all these valid expressions have in common is that they will all be of the same length i.e. as compared to the original expression, all of these expressions will have the same number of characters removed.

What if we could determine this count?

What if in addition to determining this count of characters to be removed, we could also determine the number of left parentheses and number of right parentheses to be removed from the original expression to get any valid expression?

This would cut down the computations immensely and the runtime would plummet as a result. The reason for this is, if we knew how many left and right parentheses are to be removed from the original expression to get a valid expression, we would cut down on so many unwanted recursive calls.

Imagine the original expression to be 1000 characters with only 3 misplaced ( parentheses and 2 misplaced ) parentheses. In our previous solution we would end up trying to remove each one of left and right parentheses and try to reach a valid expression in the end whereas we should only be trying out removing 3 ( brackets and 2 ) brackets.

This is the exact number of ( and ) that have to be removed to get a valid expression. No more, no less.

Let us look at how we can find out the number of misplaced left and right parentheses in a given expression first and then we will slightly modify our original algorithm to incorporate these counts as well.

We process the expression one bracket at a time starting from the left.
Suppose we encounter an opening bracket i.e. (, it may or may not lead to an invalid expression because there can be a matching ending bracket somewhere in the remaining part of the expression. Here, we simply increment the counter keeping track of left parentheses till now. left += 1
If we encounter a closing bracket, this has two meanings:
Either there was no matching opening bracket for this closing bracket and in that case we have an invalid expression. This is the case when left == 0 i.e. when there are no unmatched left brackets available. In such a case we increment another counter say right += 1 to represent misplaced right parentheses.
Or, we had some unmatched opening bracket available to match this closing bracket. This is the case when left > 0. In this case we simply decrement the left counter we had i.e. left -= 1
Continue processing the string until all parentheses have been processed.
In the end the values of left and right would tell us the number of unmatched ( and ) parentheses respectively.
Now that we have these two values available that tell us the total number of left i.e. ( and right i.e. ) parentheses that have to be removed to make the invalid expression valid, we will modify our original algorithm discussed in the previous session to avoid unwanted recursions.

Algorithm

The overall algorithm remains exactly the same as before. The changes that we will incorporate are listed below:

The state of the recursion is now defined by five different variables:
index which represents the current character that we have to process in the original string.
left_count which represents the number of left parentheses that have been added to the expression we are building.
right_count which represents the number of right parentheses that have been added to the expression we are building.
left_rem is the number of left parentheses that remain to be removed.
right_rem represents the number of right parentheses that remain to be removed. Overall, for the final expression to be valid, left_rem == 0 and right_rem == 0.
When we decide to not consider a parenthesis i.e. delete a parenthesis, be it a left or a right parentheses, we have to consider their corresponding remaining counts as well. This means that we can only discard a left parentheses if left_rem > 0 and similarly for the right one we will check for right_rem > 0.
There are no changes to checks for considering a parenthesis. Only the conditions change for discarding a parenthesis.
Condition for an expression being valid in the base case would now become left_rem == 0 and right_rem == 0. Note that we don't have to check if left_count == right_count anymore because in the case of a valid expression, we would have removed all the misplaced or invalid parenthesis by the time the recursion ends. So, the only check we need if left_rem == 0 and right_rem == 0.
The most important thing here is that we have completely gotten rid of checking if the number of parentheses removed is lesser than the current minimum or not. The reason for this is we always remove the same number of parentheses as defined by left_rem + right_rem at the start of recursion.

Now let us look at the implementation for this modified version of algorithm.
 */
// much better solution down here
/*
class Solution {

  private Set<String> validExpressions = new HashSet<String>();
  private int minimumRemoved;

  private void reset() {
    this.validExpressions.clear();
    this.minimumRemoved = Integer.MAX_VALUE;
  }

  private void recurse(
      String s,
      int index,
      int leftCount,
      int rightCount,
      StringBuilder expression,
      int removedCount) {

    // If we have reached the end of string.
    if (index == s.length()) {

      // If the current expression is valid.
      if (leftCount == rightCount) {

        // If the current count of removed parentheses is <= the current minimum count
        if (removedCount <= this.minimumRemoved) {

          // Convert StringBuilder to a String. This is an expensive operation.
          // So we only perform this when needed.
          String possibleAnswer = expression.toString();

          // If the current count beats the overall minimum we have till now
          if (removedCount < this.minimumRemoved) {
            this.validExpressions.clear();
            this.minimumRemoved = removedCount;
          }
          this.validExpressions.add(possibleAnswer);
        }
      }
    } else {

      char currentCharacter = s.charAt(index);
      int length = expression.length();

      // If the current character is neither an opening bracket nor a closing one,
      // simply recurse further by adding it to the expression StringBuilder
      if (currentCharacter != '(' && currentCharacter != ')') {
        expression.append(currentCharacter);
        this.recurse(s, index + 1, leftCount, rightCount, expression, removedCount);
        expression.deleteCharAt(length);
      } else {

        // Recursion where we delete the current character and move forward
        this.recurse(s, index + 1, leftCount, rightCount, expression, removedCount + 1);
        expression.append(currentCharacter);

        // If it's an opening parenthesis, consider it and recurse
        if (currentCharacter == '(') {
          this.recurse(s, index + 1, leftCount + 1, rightCount, expression, removedCount);
        } else if (rightCount < leftCount) {
          // For a closing parenthesis, only recurse if right < left
          this.recurse(s, index + 1, leftCount, rightCount + 1, expression, removedCount);
        }

        // Undoing the append operation for other recursions.
        expression.deleteCharAt(length);
      }
    }
  }

  public List<String> removeInvalidParentheses(String s) {

    this.reset();
    this.recurse(s, 0, 0, 0, new StringBuilder(), 0);
    return new ArrayList(this.validExpressions);
  }
}
 */
