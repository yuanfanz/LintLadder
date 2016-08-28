package DataStructure;

import java.util.Stack;

/**
 * Created by Frank on 16/8/27.
 */
public class ImplementQueueByTwoStacks {
    private Stack<Integer> stack1;
    private Stack<Integer> stack2;

    public void Queue() {
        // do initialization if necessary
        stack1 = new Stack<Integer>();
        stack2 = new Stack<Integer>();
    }

    private void stackToStack() {
        while (!stack2.isEmpty()) {
            stack1.push(stack2.pop());
        }
    }

    public void push(int element) {
        // write your code here
        stack2.push(element);
    }

    public int pop() {
        // write your code here
        if (stack1.empty() == true) {
            this.stackToStack();
        }
        return stack1.pop();
    }

    public int top() {
        // write your code here
        if (stack1.empty() == true) {
            this.stackToStack();
        }
        return stack1.peek();
    }
}
