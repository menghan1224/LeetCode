package Easy.QueueStacks;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by menghan on 2017/6/4.
 */
public class ImplementStackUsingQueues {
    public class MyStack {
        Queue<Integer> queue1=new LinkedList<>();
        Queue<Integer> queue2=new LinkedList<>();

        public void push(int x) {
            if(queue1.isEmpty())
            {
                queue1.add(x);
                while(!queue2.isEmpty())
                {
                    queue1.add(queue2.poll());
                }
            }
            else
            {
                queue2.add(x);
                while(!queue1.isEmpty())
                {
                    queue2.add(queue1.poll());
                }
            }

        }

        // Removes the element on top of the stack.
        public void pop() {
            if(!queue1.isEmpty())
                queue1.poll();
            else queue2.poll();
        }

        // Get the top element.
        public int top() {
            if(!queue1.isEmpty())
                return queue1.peek();
            else return queue2.peek();
        }

        // Return whether the stack is empty.
        public boolean empty() {
            return queue1.isEmpty()&&queue2.isEmpty();
        }
    }
}
