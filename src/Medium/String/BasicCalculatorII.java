package Medium.String;

import DataStructure.Interval;

import java.util.Stack;

/**
 * Created by 28479 on 2017/6/14.
 */
public class BasicCalculatorII {
    public static void main(String[] args){
        new BasicCalculatorII().calculate("0-2147483647");
    }
    public int calculate(String s) {
        int res=0;
        Stack<Integer> num=new Stack<>();
        char op='+';
        int i=0;
        while(i<s.length()){
            while(i<s.length()&&s.charAt(i)==' ') i++;
            if(i==s.length()) break;
            if(s.charAt(i)=='+'||s.charAt(i)=='-'||s.charAt(i)=='*'||s.charAt(i)=='/'){
                op=s.charAt(i);
                i++;
            }
            else {
                int k = 0;
                while (i < s.length() && s.charAt(i) >= '0' && s.charAt(i) <= '9') {
                    k = k * 10 + (s.charAt(i) - '0');
                    i++;
                }
                if (op == '+') num.push(k);
                else if (op == '-') num.push(-k);
                else if (op == '*') num.push(num.pop() * k);
                else if (op == '/') num.push(num.pop() / k);
            }
        }
        for(int k:num){
            res+=k;
        }
        return res;
    }
}
