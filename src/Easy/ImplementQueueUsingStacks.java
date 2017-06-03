package Easy;

import java.util.Stack;

/**
 * Created by 28479 on 2017/6/3.
 */
public class ImplementQueueUsingStacks {
    class MyQueue{
        Stack<Integer> stack1;
        Stack<Integer> stack2;
        public MyQueue() {
            stack1=new Stack<Integer>();
            stack2=new Stack<Integer>();
        }

        /** Push element x to the back of queue. */
        public void push(int x) {
            stack1.push(x);
        }

        /** Removes the element from in front of queue and returns that element. */
        public int pop() {
            if(stack2.isEmpty()) {
                while (!stack1.isEmpty()) {
                    stack2.push(stack1.pop());
                }
            }
            return stack2.pop();
        }

        /** Get the front element. */
        public int peek() {
            if(stack2.isEmpty()) {
                while (!stack1.isEmpty()) {
                    stack2.push(stack1.pop());
                }
            }
            return stack2.peek();
        }

        /** Returns whether the queue is empty. */
        public boolean empty() {
            return stack1.isEmpty()&&stack2.isEmpty();
        }
    }
}
