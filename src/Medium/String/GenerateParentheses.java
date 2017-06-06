package Medium.String;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by 28479 on 2017/6/6.
 */
public class GenerateParentheses {
    public static void main(String[] args){
        System.out.print(new GenerateParentheses().generateParenthesis(3));
    }
    public List<String> generateParenthesis(int n) {
        List<String> list=new ArrayList<>();
        genPar("",list,n,n);
        return list;
    }
    public void genPar(String str,List<String> list,int left,int right){
        if(left<0||right<0) return;
        if(left==0&&right==0) list.add(new String(str));
        if(left<right){
            genPar(str+"(",list,left-1,right);
            genPar(str+")",list,left,right-1);
        }else{
            genPar(str+"(",list,left-1,right);
        }
    }
}
