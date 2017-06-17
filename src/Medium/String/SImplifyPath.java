package Medium.String;

import java.util.Stack;

/**
 * Created by 28479 on 2017/6/17.
 */
public class SImplifyPath {
    public static void main(String[] args){
        System.out.println(new SImplifyPath().simplifyPath("/.."));
    }
    public String simplifyPath(String path) {
        Stack<String> stack = new Stack<>();
        int i = 0;
        StringBuilder sb = new StringBuilder();
        while (i < path.length()) {
            if (path.charAt(i) == '/') {
                int k=i+1;
                while(k<path.length()&&path.charAt(k)!='/'){
                    sb.append(path.charAt(k++));
                }
                i=k;
                String res = sb.toString();
                sb = new StringBuilder();
                if (res.equals("..") ) {
                    if(!stack.isEmpty())
                        stack.pop();
                } else if (res.equals(".")) {
                    continue;
                }
                else if(res.length()!=0){
                    stack.push(res);
                }
            }
        }
        String simple = "";
        while (!stack.isEmpty()) {
            simple="/"+stack.pop()+simple;
        }
        return simple.length()>0?simple:"/";
    }
}
