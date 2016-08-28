package DataStructure;

import java.util.Stack;

/**
 * Created by Frank on 16/8/27.
 */
public class MinStack {
    private Stack<Integer> stack;
    private Stack<Integer> minStack;

    public MinStack() {
        // do initialize if necessary
        stack = new Stack<Integer>();
        minStack = new Stack<Integer>();
    }

    public void push(int number) {
        // write your code here
        stack.push(number);
        if (minStack.isEmpty()) {
            minStack.push(number);
        } else {
            minStack.push(Math.min(number, minStack.peek()));
        }
    }

    public int pop() {
        // write your code here
        minStack.pop();
        return stack.pop();
    }

    public int min() {
        // write your code here
        return minStack.peek();
    }


    /**
     * 第二种方法 会省一些空间 但是空间复杂度还是一样的
     * 因为最坏情况下没变  5 4 3 2 1 minstack一直在更新
     * @param number
     */
    public void push2(int number) {
        // write your code here
        stack.push(number);
        if (minStack.isEmpty()) {
            minStack.push(number);
        } else if (minStack.peek() >= number) {
            minStack.push(number);
        }
    }

    public int pop2() {
        // write your code here
        if (stack.peek().equals(minStack.peek())) {
            minStack.pop();
        }
        return stack.pop();
    }

    public int min2() {
        // write your code here
        return minStack.peek();
    }
}

