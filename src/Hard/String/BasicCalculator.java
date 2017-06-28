package Hard.String;

import java.util.Stack;

/**
 * Created by menghan on 2017/6/28.
 */
public class BasicCalculator {
    public int calculate(String s) {
        s=s.trim();
        if(s.length()==0) return 0;
        int i=0;
        Stack<Character> op=new Stack<>();
        Stack<Integer> num = new Stack<Integer>();
        while(i<s.length()){
            if(s.charAt(i)==' ') {
                i++;
                continue;
            }
            if(s.charAt(i)=='+'||s.charAt(i)=='-'||s.charAt(i)=='(') op.push(s.charAt(i++));
            else if(s.charAt(i)==')'){
                while(!op.isEmpty()&&op.peek()!='('){
                    Character oper=op.pop();
                    int k1=num.pop(),k2=num.pop();
                    if(oper=='+') num.push(k1+k2);
                    else if(oper=='-') num.push(k2-k1);
                }
                op.pop();
                i++;
                while(!op.isEmpty()&&op.peek()!='('){
                    if(op.peek()=='+'){
                        op.pop();
                        num.push(num.pop()+num.pop());
                    }else if(op.peek()=='-'){
                        op.pop();
                        num.push(-num.pop()+num.pop());
                    }
                }
            }
            else{
                int k = 0;
                while(i<s.length()&&s.charAt(i)>='0'&&s.charAt(i)<='9') k=k*10+(s.charAt(i++)-'0');
                if(!op.isEmpty()&&op.peek()=='+') {
                    num.push(num.pop()+k);
                    op.pop();
                }else if(!op.isEmpty()&&op.peek()=='-'){
                    num.push(num.pop()-k);
                    op.pop();
                }
                else num.push(k);
            }
        }
        return num.peek();
    }
}
