package Medium.Array;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by 28479 on 2017/6/6.
 */
public class CombinationSumIII {
    public static void main(String[] args){
        System.out.println(new CombinationSumIII().combinationSum3(3,9));
    }
    public List<List<Integer>> combinationSum3(int k, int n) {
        List<List<Integer>> list=new ArrayList<List<Integer>>();
        getSum(list,new ArrayList<>(),k,1,n);
        return list;
    }
    public void getSum(List<List<Integer>> list,List<Integer> sublist,int k,int now,int n){
        if(n==0&&k==0){
            list.add(new ArrayList<>(sublist));
            return;
        }
        if(k<0||n<0) return;
        for(int i=now;i<=n;i++){
            sublist.add(i);
            getSum(list,sublist,k-1,i+1,n-i);
            sublist.remove(new Integer(i));
        }
    }
}
