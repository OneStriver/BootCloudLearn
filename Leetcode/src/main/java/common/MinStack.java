package common;

import java.util.Stack;
/**
 * @description:
 * @author: HeYin
 * @date: 2020/06/18
 */
public class MinStack {

    private Stack<Integer> stack;
    private Stack<Integer> minStack;

    /**
     * initialize your data structure here.
     */
    public MinStack() {
        stack = new Stack<>();
        minStack = new Stack<>();
    }

    public void push(int x) {
        stack.push(x);
        if (minStack.empty()) {
            minStack.push(x);
        } else {
            if (minStack.peek() >= x) {
                minStack.push(x);
            }
        }
    }

    public void pop() {
        if (stack.empty()) {
            return;
        }
        Integer pop = stack.pop();
        if (!minStack.empty() && pop != null) {
            Integer peek = minStack.peek();
            if (peek.equals(pop)) {
                minStack.pop();
            }
        }
    }

    public int top() {
        Integer result = stack.peek();
        //    if (result == null) {
        //      throw new Exception("stack is empty");
        //    }
        return result;
        //    return result == null ? null : result;
    }

    public int getMin() {
        return minStack.peek();
    }

}
