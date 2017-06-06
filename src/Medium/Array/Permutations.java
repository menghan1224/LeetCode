package Medium.Array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by 28479 on 2017/6/6.
 */
public class Permutations {
    public static void main(String[] args){
        new Permutations().permute(new int[]{1,2,3});
    }
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> list=new ArrayList<List<Integer>>();
        arrange(nums,0,nums.length,list);
        return  list;
    }
    public void arrange (int[] str, int st, int len,List<List<Integer>> list)
    {
        if (st == len - 1)
        {
            List<Integer> sublist=new ArrayList<Integer>();
            for(int num:str)
                sublist.add(num);
        }
        else
        {
            for (int i = st; i < len; i ++)
            {
                swap(str, st, i);
                arrange(str, st + 1, len,list);
                swap(str, st, i);
            }
        }
    }
    public void swap(int[] arr,int i,int j){
        int tmp=arr[i];
        arr[i]=arr[j];
        arr[j]=tmp;
    }
}
