package Medium.String;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by 28479 on 2017/6/16.
 */
public class RestoreIpAddress {
    public static void main(String[] args){
        System.out.println(new RestoreIpAddress().restoreIpAddresses("010010"));
    }
    public List<String> restoreIpAddresses(String s) {
        List<String> res=new ArrayList<>();
        getList(s,0,0,"",res);
        return res;
    }
    public void getList(String s,int begin,int num,String sub,List<String> list){
        if(num>4) return;
        if(num==4&&begin==s.length()){
            list.add(sub.substring(0,sub.length()-1));
            return;
        }
        for(int i=begin+1;i<=Math.min(begin+3,s.length());i++){
            String add=s.substring(begin,i);
            if(add.length()>1&&add.charAt(0)=='0') return;
            if(Integer.parseInt(add)>=0&&Integer.parseInt(add)<=255)
                getList(s,i,num+1,sub+add+".",list);
            else return;
        }
    }
}
