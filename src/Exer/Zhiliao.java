package Exer;

/**
 * Created by menghan on 2017/10/18.
 */
public class Zhiliao {
    public static void main(String[] args) {
        System.out.println(solution("abcadabcabcad"));
    }
    private static String solution(String line) {
        // 在此处理单行数据
        String res = check(new StringBuilder(line.substring(0,1)),0,line,1);
        //回处理后的结果
        return res;
    }
    private static String check(StringBuilder prefix,int begin,String line,int index){
        if(index==line.length()) return prefix.toString();
        if(begin==prefix.length()) begin = 0;
        if(prefix.charAt(begin)==line.charAt(index)) {
            String str1 = check(prefix,begin+1,line,index+1);
            String str2 = str1;
            if(prefix.charAt(0)==line.charAt(index)) str2 = check(prefix,1,line,index+1);
            return str1.length()>str2.length()?str2:str1;
        }
        else if(prefix.charAt(0)==line.charAt(index)) return check(prefix,1,line,index+1);
        prefix.append(prefix.substring(0,begin)).append(line.charAt(index));
        return check(prefix,0,line,index+1);
    }
}
