package Medium.Array;

import java.util.Arrays;

/**
 * Created by menghan on 2017/6/13.
 */
public class ThreeSumClosest {
    public static void main(String[] args){
        new ThreeSumClosest().threeSumClosest(new int[]{1,1,1,0},100);
    }
    public int threeSumClosest(int[] nums, int target) {
        int diff=Integer.MAX_VALUE;
        int res=0;
        Arrays.sort(nums);
        for(int i=0;i<nums.length;i++){
            int tmpTarget=target-nums[i];
            int begin=i+1;
            int end=nums.length-1;
            while(begin<end){
                int cha=nums[begin]+nums[end]-tmpTarget;
                if(cha>0) end--;
                else begin++;
                if(Math.abs(cha)<diff){
                    diff=Math.abs(cha);
                    res=nums[begin]+nums[end]+nums[i];
                }
            }

        }
        return res;
    }
}
