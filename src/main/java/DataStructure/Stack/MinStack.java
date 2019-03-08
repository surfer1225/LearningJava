package main.java.DataStructure.Stack;

/**
 * Created by Ryan on 30/12/17.
 */

/*
Design a stack that supports push, pop, top, and retrieving the minimum element in constant time.

push(x) -- Push element x onto stack.
pop() -- Removes the element on top of the stack.
top() -- Get the top element.
getMin() -- Retrieve the minimum element in the stack.
Example:
MinStack minStack = new MinStack();
minStack.push(-2);
minStack.push(0);
minStack.push(-3);
minStack.getMin();   --> Returns -3.
minStack.pop();
minStack.top();      --> Returns 0.
minStack.getMin();   --> Returns -2.

 */
public class MinStack {

    int[] arr;
    int min;
    int size;
    int top;

    /** initialize your data structure here. */
    public MinStack() {
        size = 50;
        arr = new int[size];
        min = Integer.MAX_VALUE;
        top = -1;
    }

    public void push(int x) {
        if (top == (size - 1)) {
            size*=2;
            int[] temp = arr;
            arr = new int[size];
            for (int i=0;i<temp.length;i++) {
                arr[i]=temp[i];
            }
        }
        min=x<min?x:min;
        top++;
        arr[top]=x;
    }

    public void pop() {
        if (min==arr[top]) {
            min = Integer.MAX_VALUE;
            for (int i=0;i<top;i++) min = arr[i]<min?arr[i]:min;
        }
        top--;
    }

    public int top() {
        return arr[top];
    }

    public int getMin() {
        return min;
    }
    /**
     * Your MinStack object will be instantiated and called as such:
     * MinStack obj = new MinStack();
     * obj.push(x);
     * obj.pop();
     * int param_3 = obj.top();
     * int param_4 = obj.getMin();
     */
}
