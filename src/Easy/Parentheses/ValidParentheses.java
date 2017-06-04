package Easy.Parentheses;

import java.util.Stack;

/**
 * Created by menghan on 2017/6/4.
 */
public class ValidParentheses {
    public boolean isValid(String s) {
        Stack<Character> stack=new Stack<Character>();
        for(int i=0;i<s.length();i++){
            if(s.charAt(i)=='('||s.charAt(i)=='['||s.charAt(i)=='{') stack.push(s.charAt(i));
            else{
                if(s.charAt(i)==')'){
                    if(!stack.isEmpty()&&stack.peek()=='(') stack.pop();
                    else return false;
                }
                if(s.charAt(i)==']'){
                    if(!stack.isEmpty()&&stack.peek()=='[') stack.pop();
                    else return false;
                }
                if(s.charAt(i)=='}'){
                    if(!stack.isEmpty()&&stack.peek()=='{') stack.pop();
                    else return false;
                }
            }
        }
        return stack.isEmpty();
    }
}
