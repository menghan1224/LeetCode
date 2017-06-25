package Hard.String;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by menghan on 2017/6/25.
 */
public class ExpressionAddOperators {
    public static void main(String[] args){
        System.out.println(new ExpressionAddOperators().addOperators("123",6));
    }
    public List<String> addOperators(String num, int target) {
        List<String> res=new ArrayList<>();
        helper(num,"",0,target,res,0);
        return res;
    }
    public void helper(String num,String str,long curRes,long target,List<String> res,long preNum){
        if(num.length()==0){
            if(curRes==target) res.add(str);
            return;
        }
        for(int i=1;i<=num.length();i++){
            String cur=num.substring(0,i);
            if(cur.length()>1&&cur.charAt(0)=='0') continue;
            long curNum=Long.parseLong(cur);
            String remain=num.substring(i);
            if(str.length()>0){
                helper(remain,str+"*"+curNum,curRes-preNum+curNum*preNum,target,res,curNum*preNum);
                helper(remain,str+"+"+curNum,curRes+curNum,target,res,curNum);
                helper(remain,str+"-"+curNum,curRes-curNum,target,res,-curNum);
            }else helper(remain,""+curNum,curNum,target,res,curNum);
        }
    }
}
