package Medium.Array;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by 28479 on 2017/6/7.
 */
public class SubSets {
    List<List<Integer>> list=new ArrayList<List<Integer>>();
    public List<List<Integer>> subsets(int[] nums) {
        getlist(new ArrayList<>(),0,nums.length-1,nums);
        return list;
    }
    public void getlist(List<Integer> sublist,int begin,int end,int[] nums){
        if(begin>nums.length) return;
        List<Integer> temp=new ArrayList<>(sublist);
        list.add(temp);
        for(int i=begin;i<=end;i++){
            sublist.add(nums[i]);
            getlist(sublist,i+1,end,nums);
            sublist.remove(sublist.size()-1);
        }
    }
}
