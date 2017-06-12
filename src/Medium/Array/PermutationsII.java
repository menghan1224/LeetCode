package Medium.Array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by menghan on 2017/6/12.
 */
public class PermutationsII {
    public static void main(String[] args){
        int[] arr={1,2,3,4};
        new PermutationsII().reverse(arr,0,3);
        for(int num:arr)
            System.out.print(num);
    }
    public List<List<Integer>> permuteUnique(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> list=new ArrayList<List<Integer>>();
        while(true) {
            List<Integer> sublist = new ArrayList<>();
            for (int num : nums)
                sublist.add(num);
            list.add(sublist);
            int i;
            for (i = nums.length - 1; i > 0; i--) {
                if (nums[i - 1] < nums[i]) break;
            }
            if (i == 0) return list;
            int k;
            for (k = nums.length - 1; k > i; k--) {
                if (nums[k] > nums[i - 1]) break;
            }
            swap(nums, k, i - 1);
            reverse(nums, i, nums.length - 1);
        }
    }
    public void swap(int[] arr,int i,int j){
        int tmp=arr[i];
        arr[i]=arr[j];
        arr[j]=tmp;
    }
    public void reverse(int[] arr,int i,int j){
        while(i<j){
            swap(arr,i++,j--);
        }
    }

}
