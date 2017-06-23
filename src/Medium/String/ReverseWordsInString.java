package Medium.String;

import java.util.Stack;

/**
 * Created by menghan on 2017/6/23.
 */
public class ReverseWordsInString {
    public String reverseWords(String s) {
        Stack<String> stack=new Stack<>();
        StringBuilder sb=new StringBuilder();
        for(int i=0;i<s.length();i++){
            if(s.charAt(i)==' '){
                if(sb.length()>0) stack.push(sb.toString());
                sb=new StringBuilder();
            }else{
                sb.append(s.charAt(i));
            }
        }
        if(sb.length()>0) stack.push(sb.toString());
        sb=new StringBuilder();
        while(!stack.isEmpty()){
            sb.append(stack.pop()+" ");
        }
        String res=sb.toString();
        return res.length()>0?res.substring(0,res.length()-1):res;
    }
}
