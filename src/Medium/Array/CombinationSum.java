package Medium.Array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by 28479 on 2017/6/7.
 */
public class CombinationSum {
    private List<List<Integer>> list=new ArrayList<List<Integer>>();
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        Arrays.sort(candidates);
        getlist(new ArrayList<>(),candidates,0,target);
        return list;
    }
    public void getlist(List<Integer> sublist,int[] candidats,int index,int target){
        if(target==0){
            List<Integer> ans=new ArrayList<>(sublist);
            list.add(ans);
        }
        else {
            for (int i = index; i < candidats.length && candidats[i] <= target; i++) {
                sublist.add(candidats[i]);
                getlist(sublist, candidats, i, target - candidats[i]);
                sublist.remove(new Integer(candidats[i]));
            }
        }
    }
}
