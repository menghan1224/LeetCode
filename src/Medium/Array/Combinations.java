package Medium.Array;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by 28479 on 2017/6/7.
 */
public class Combinations {
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> list=new ArrayList<List<Integer>>();
        getList(list,new ArrayList<>(),1,k,n);
        return list;
    }
    public void getList(List<List<Integer>> list,List<Integer> sublist,int begin,int k,int n){
        if(k==0){
            List<Integer> tmplist=new ArrayList<>(sublist);
            list.add(tmplist);
            return;
        }
        for(int i=begin;i<=n;i++){
            sublist.add(i);
            getList(list,sublist,i+1,k-1,n);
            sublist.remove(sublist.size()-1);
        }
    }

}
