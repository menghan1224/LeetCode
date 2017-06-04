package Easy.QueueStacks;

import java.util.Stack;

/**
 * Created by menghan on 2017/6/4.
 */
public class MinStack {
    Stack<Integer> stack=new Stack<Integer>();
    Stack<Integer> minStack=new Stack<Integer>();
    public MinStack() {

    }

    public void push(int x) {
        stack.push(x);
        if(minStack.isEmpty()||x<minStack.peek())
            minStack.push(x);
    }

    public void pop() {
        int val=stack.pop();
        if(val==minStack.peek())
            minStack.pop();
    }

    public int top() {
        return stack.peek();
    }

    public int getMin() {
        return minStack.peek();
    }
}
