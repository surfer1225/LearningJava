package main.java.DataStructure.Stack;

import java.util.Stack;

public class StackWithTransaction {
    private Stack<Stack<Integer>> transactions = new Stack<>();
    private Stack<Integer> stack = new Stack<>();
    public void push(int data)
    {
        if (transactions.isEmpty())
        {
            stack.push(data);
            return;
        }
        transactions.peek().push(data);
    }

    public void pop()
    {
        if (transactions.isEmpty())
        {
            stack.pop();
            return;
        }
        transactions.peek().pop();
    }

    public int top() {
        int val = 0;
        if (transactions.isEmpty()) {
            return stack.peek();
        } else {
            int popCnt = 0;
            while (!transactions.isEmpty() && transactions.peek().isEmpty()) {
                transactions.pop();
                popCnt++;
            }
            if (transactions.isEmpty()) {
                val = stack.peek();
            } else {
                val = transactions.peek().peek();
            }
            while (popCnt > 0) {
                transactions.push(new Stack<>());
                popCnt--;
            }
            return val;
        }
    }

    public void begin()
    {
        transactions.push(new Stack());
    }

    public boolean rollback()
    {
        if (transactions.isEmpty()) return false;
        transactions.pop();
        return true;
    }

    public boolean commit()
    {
        if (transactions.isEmpty()) return false;
        Stack<Integer> peek = transactions.peek();
        transactions.pop();

        Stack<Integer> stackToAdd = transactions.isEmpty()
                ? stack
                : transactions.peek();

        append(stackToAdd, peek);
        return true;
    }


    private void append(Stack<Integer> main, Stack<Integer> sub) {
        Stack<Integer> tmp = new Stack<>();
        for (Integer integer : sub) {
            tmp.add(integer);
        }

        for (Integer integer : tmp) {
            main.add(integer);
        }
    }
}
