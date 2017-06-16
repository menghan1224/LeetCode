package Medium.String;

import java.util.Stack;

/**
 * Created by 28479 on 2017/6/16.
 */
public class EvaluateReversePolishNotation {
    public static void main(String[] args){
        System.out.println(Integer.parseInt("-123"));
    }
    public int evalRPN(String[] tokens) {
        Stack<Integer> stack=new Stack<>();
        for(int i=0;i<tokens.length;i++){
            if(tokens[i].equals("+")||tokens[i].equals("-")||tokens[i].equals("*")||tokens[i].equals("/")){
                int num1=stack.pop();
                int num2=stack.pop();
                if(tokens[i].equals("+")) stack.push(num1+num2);
                else if(tokens[i].equals("-")) stack.push(num2-num1);
                else if(tokens[i].equals("*")) stack.push(num2*num1);
                else if(tokens[i].equals("/")) stack.push(num2/num1);
            }
            else{
                stack.push(Integer.parseInt(tokens[i]));
            }
        }
        return stack.peek();
    }
}
