package main.java.leetcode.RevisionQns;

/*
470. Implement Rand10() Using Rand7()

Given a function rand7 which generates a uniform random integer in the range 1 to 7,
write a function rand10 which generates a uniform random integer in the range 1 to 10.

Do NOT use system's Math.random().

Example 1:

Input: 1
Output: [7]
Example 2:

Input: 2
Output: [8,4]
Example 3:

Input: 3
Output: [8,1,10]
 */
public class Rand10 {
    public int rand10() {
        int row, col, ind;
        do {
            row = rand7();
            col = rand7();
            ind = col+(row-1)*7;
        } while(ind>40);
        return ind%10+1;
    }

    private int rand7() {
        return (int) (Math.random() * 7);
    }
}
