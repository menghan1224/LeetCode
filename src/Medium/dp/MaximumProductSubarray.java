package Medium.dp;

/**
 * Created by 28479 on 2017/6/16.
 */
public class MaximumProductSubarray {
    public int maxProduct(int[] nums) {
        if(nums.length==0) return 0;
        int[] max=new int[nums.length];
        int[] min=new int[nums.length];
        int res=Integer.MIN_VALUE;
        max[0]=nums[0];
        min[0]=nums[0];
        for(int i=1;i< nums.length;i++){
            max[i]=Math.max(nums[i],Math.max(max[i-1]*nums[i],min[i-1]*nums[i]));
            min[i]=Math.min(nums[i],Math.min(min[i-1]*nums[i],max[i-1]*nums[i]));
            if(max[i]>res) res=max[i];
        }
        return res;
    }
}
