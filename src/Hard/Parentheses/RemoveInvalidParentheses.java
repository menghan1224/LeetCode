package Hard.Parentheses;

import java.util.*;

/**
 * Created by menghan on 2017/6/24.
 */
public class RemoveInvalidParentheses {
    public static void main(String[] args){
        System.out.println(new RemoveInvalidParentheses().removeInvalidParentheses("()())()"));
    }
    public List<String> removeInvalidParentheses(String s) {
        Queue<String> queue=new LinkedList<>();
        List<String> res=new ArrayList<>();
        boolean found=false;
        Set<String> visited=new HashSet<>();
        queue.offer(s);
        visited.add(s);
        while(!queue.isEmpty()){
            String par=queue.poll();
            if(isValid(par)){
                res.add(par);
                found=true;
            }
            if(found) continue;
            for(int i=0;i<par.length();i++){
                if(par.charAt(i)!='('&&par.charAt(i)!=')') continue;
                String tmp=par.substring(0,i)+par.substring(i+1);
                if(!visited.contains(tmp)){
                    queue.offer(tmp);
                    visited.add(tmp);
                }
            }
        }
        return res;
    }
    public boolean isValid(String s){
        int count=0;
        for(int i=0;i<s.length();i++){
            if(s.charAt(i)=='(') count++;
            if(s.charAt(i)==')'&&count--==0) return  false;
        }
        return count==0;
    }
}
